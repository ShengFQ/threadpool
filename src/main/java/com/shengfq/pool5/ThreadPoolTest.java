package com.shengfq.pool5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ClassName: ThreadPoolTest
 * Description: jdk自带的Executors线程池测试
 * 文档来源:https://cloud.tencent.com/developer/article/1529634
 * @author shengfq
 * @date: 2023/3/22 10:34 上午
 */
public class ThreadPoolTest {

    public static void main(String[] args) throws Exception {
        ThreadPoolTest threadPoolTest=new ThreadPoolTest();
        ExecutorService executor=threadPoolTest.testFixedThreadPool();
        testThreadPool(executor);

        ExecutorService executor2=threadPoolTest.testSingleThreadPool();
        testThreadPool(executor2);

        ExecutorService  executor3=threadPoolTest.testCachedThreadPool();
        testThreadPool(executor3);

        ExecutorService executor4=threadPoolTest.testScheduledThreadPool();
        testThreadPool(executor4);
    }

    //允许请求队列长度为Integer.MAX_VALUE可能会堆积大量请求从而导致OOM
    private  ExecutorService testFixedThreadPool() throws Exception{
        ExecutorService executor = Executors.newFixedThreadPool(10);
        return executor;
    }
    //允许请求队列长度为Integer.MAX_VALUE可能会堆积大量请求从而导致OOM
    private  ExecutorService testSingleThreadPool() throws Exception{
        ExecutorService executor = Executors.newSingleThreadExecutor();
        return executor;
    }
    //允许创建线程数量为Integer.MAX_VALUE可能会创建大量线程从而导致OOM
    private  ExecutorService testCachedThreadPool() throws Exception{
        ExecutorService executor = Executors.newCachedThreadPool();
        return executor;
    }
    //允许创建线程数量为Integer.MAX_VALUE可能会创建大量线程从而导致OOM
    private  ExecutorService testScheduledThreadPool() throws Exception{
        ExecutorService executor = Executors.newScheduledThreadPool(10);
        return executor;
    }

    private static void testThreadPool(ExecutorService executor) throws Exception{
        for (int i = 0; i < 1000; i++) {
            final int index = i;
            Thread.sleep(4000);
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "  " + index);
                }
            });
        }
        executor.shutdown();
    }
}
