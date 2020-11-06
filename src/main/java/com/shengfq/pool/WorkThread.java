package com.shengfq.pool;
import java.util.concurrent.BlockingQueue;
/**
 * <p>Title: </p>
 * <p>Description: use to test thread pool</p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 *
 * @author xingyong
 * 
 * @version 1.0
 */

public class WorkThread extends Thread
{
   
   public int threadNum;
   private boolean flag;

   private BlockingQueue<Task> taskQueue;
   private Task task;

   /**
    * @param vector
    * @param i
    */
   public WorkThread(BlockingQueue<Task> vector, int i)
   {
        flag = true;
        threadNum = i;
        taskQueue = vector;
        //hide entry here
        super.start();
   }

   public void run()
   {
	   //使用状态变量flag的意义就是加入人为因素控制循环.
        while(flag && taskQueue != null)
        {
            	try
                {
                    task = (Task)taskQueue.take();
                }
                catch(Exception ex)
                {
                    task = null;
                }
                if(task == null)
                    continue;
            
            try
            {
                task.setEnd(false);
                task.startTask();
            }
            catch(Exception ex)
            {
                 ex.printStackTrace();
            }
            try
            {
                if(!task.isEnd())
                {
                    task.setEnd(true);
                    task.endTask();
                }
            }
            catch(Exception ex)
            {
                 ex.printStackTrace();
            }
          
        }//end of while
   }

   public void closeThread()
   {
        flag = false;
        try
        {
            if(task != null)
                task.endTask();
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        synchronized(taskQueue)
        {
            taskQueue.notifyAll();
        }
   }
}
