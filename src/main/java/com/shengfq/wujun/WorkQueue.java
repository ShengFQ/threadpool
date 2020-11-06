package com.shengfq.wujun;

import java.util.LinkedList;
/**
 *  具有线程池的工作队列
 *  队列执行任务
 * */
public class WorkQueue
{
	
    private final int nThreads;
    private final PoolWorker[] threads;//线程池
    private final LinkedList<Runnable> queue;//工作队列
    public WorkQueue(int nThreads)
    {
        this.nThreads = nThreads;
        queue = new LinkedList();
        threads = new PoolWorker[nThreads];
        for (int i=0; i<nThreads; i++) {
            threads[i] = new PoolWorker();
            threads[i].start();
        }
    }
    public void execute(Runnable r) {
        synchronized(queue) {
            queue.addLast(r);
            queue.notify();
        }
    }
    private class PoolWorker extends Thread {
        public void run() {
            Runnable r;
            while (true) {
                synchronized(queue) {
                    while (queue.isEmpty()) {
                        try
                        {
                            queue.wait();
                        }
                        catch (InterruptedException ignored)
                        {
                        }
                    }
                    r = (Runnable) queue.removeFirst();
                }
                // If we don't catch RuntimeException, 
                // the pool could leak threads
                try {
                    r.run();
                }
                catch (RuntimeException e) {
                    // You might want to log something here
                }
            }
        }
       
    }
    
    public static void main(String[] args) {
    	
    	WorkQueue queue=new WorkQueue(10);//10个线程池初始化
    	long start=System.currentTimeMillis();
    	Tasker task=queue.new Tasker();
    	task.doTask();
    	long end=System.currentTimeMillis()-start;
    	System.out.println("总共耗时:"+end);
	}
    /**
     * 我的任务是对于模拟100个客户端线程打印自己
     * */
    private class Tasker {
    		public void doTask(){
    			for(int i=0;i<100;i++){
   				 Thread t=new Thread(new Runnable() {					
   					@Override
   					public void run() {
   						System.out.println("我是线程:"+Thread.currentThread().getName());
   						try {
   							Thread.sleep(500);
   						} catch (InterruptedException e) {
   							e.printStackTrace();
   						};
   					}
   				},"Thread."+i);	
   				queue.add(t);
    		}
    		}
    }
}