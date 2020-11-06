package com.shengfq.pool;
import java.util.Vector;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
/**
 * <p>Title: </p>
 * <p>Description: use to test simple thread pool</p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 *
 * @author xingyong
 *
 * @version 1.0
 */
public class ThreadPoolManager
{

   /**
    * the number of threads in pool
    */
   private int threadNum;
   /**
    * the default number of threads in pool
    */
   private int defaultThreadNum=10;
   /**
    * the vector of threads in pool
    */
   private Vector<WorkThread> workThreadVector;
   /**
    * the BlockingQueue of tasks
    */
   private BlockingQueue<Task> taskVector;// TODO 怎么自动扩容

   /**
    * @param i
    */
   public ThreadPoolManager(int i)
   {
        taskVector = new LinkedBlockingQueue<Task>(100);
        //initial thread number
        defaultThreadNum = 10;
        if(i > 0)
            defaultThreadNum = i;
        //call thread
        CreateThreadPool(i);
   }

   public ThreadPoolManager()
   {
        this(10);
   }
   /**
    *
    * @return
    */
   public boolean isAllTaskFinish()
   {
     return taskVector.isEmpty();
   }
   /**
    * @return int
    */
   public int getThreadNum()
   {
        return threadNum;
   }



   /**
    * create thread pool
    * @param i
    */
   private void CreateThreadPool(int i)
   {
        if(workThreadVector == null)
            workThreadVector = new Vector<WorkThread>(i);
        Object obj = null;
        //create threads
        synchronized(workThreadVector)
        {
            for(int j = 0; j < i; j++)
            {
                threadNum++;
                WorkThread workThread = new WorkThread(taskVector, threadNum);
                workThreadVector.addElement(workThread);
            }

        }
   }

   /**
    * add task to task vector and notify work Threads in pool
    * to do it
    * @param taskObj
    */
   public void addTask(Task taskObj)
   {
        if(taskObj == null)
            return;        
            try {
				taskVector.put(taskObj);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
          
   }

  /**
   * destroy  threads in pool
   */
   public void closeThread()
   {
        Object obj = null;

        while(!workThreadVector.isEmpty())
        {
            try
            {
                WorkThread workThread = (WorkThread)workThreadVector.remove(0);
                workThread.closeThread();
                continue;
            }
            catch(Exception exception)
            {

                    exception.printStackTrace();
            }
            break;
        }
   }
}
