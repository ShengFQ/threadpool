package com.shengfq.juc;

import java.util.Scanner;
import java.util.concurrent.*;

/**
 * juc自带的线程池
 * 2019年11月23日20:49:39
 * @author shengfq
 * @version 1.1
 * */
public class ExecutorTest {
    private static final int size=20,threadCount=5;
    private static BlockingQueue<Integer> taskQueue=new ArrayBlockingQueue<Integer>(size);
    private Executor mExecutor;


    /**
     * 创建一个1.newCachedThreadPool创建一个可缓存线程池，
     * 如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
     * */
    private static ExecutorService createThreadPool(){
      return  Executors.newCachedThreadPool();
    }
    /**
     *  2.newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
     * */
    private static ExecutorService createThreadPool2(){
        return  Executors.newFixedThreadPool(threadCount);
    }
    /**
     * 3.newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
     * */
    private static ExecutorService createThreadPool3(){
        return  Executors.newScheduledThreadPool(threadCount);
    }

    /**
     *4.newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，
     * 保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
     * */
    private static ExecutorService createThreadPool4(){
        return  Executors.newSingleThreadExecutor();
    }
    /**
     * 1.线程池的妙用,这里并没有循环创建线程对象,而是将runnable对象放到pool.execute()中.
     *
     *
     * */
    public static void main(String[] args) {
        Producer producer=new Producer(taskQueue);
        Consumer consumer=new Consumer(taskQueue);
        ThreadPoolExecutor pool1=(ThreadPoolExecutor)createThreadPool();
        pool1.execute(producer);
        pool1.execute(consumer);

        Scanner input=new Scanner(System.in);
        while(input.hasNext()){
            String in=input.next();
            if("q".equals(in)){
                System.out.println("system will shutdown");
                System.exit(0);
            }else if("pstop".equals(in)){
                producer.stop();
            }else if("cstop".equals(in)){
                consumer.stop();
            }
        }

    }

}
