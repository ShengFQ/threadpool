package com.shengfq.pool5;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ClassName: ThreadPoolTest
 * Description: jdk自带的Executors线程池测试
 * 文档来源:https://cloud.tencent.com/developer/article/1529634
 * @author shengfq
 * @date: 2023/3/22 10:34 上午
 */
public class ThreadPoolTest {

    public static void main(String[] args) throws Exception {
        testCachedThreadPool();
    }

    private static void testCachedThreadPool() throws Exception{
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
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

    public static void testFixedThreadPool() throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(1);

        for (int i = 0; i < 1000; i++) {
            final int index = i;
            executor.execute(() -> {
                try {
                    Thread.sleep(1 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "  " + index);
            });
        }
        executor.shutdown();
    }

    public static void method_02() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);

        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                long start = new Date().getTime();
                System.out.println("scheduleAtFixedRate 开始执行时间:" +
                        DateFormat.getTimeInstance().format(new Date()));
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long end = new Date().getTime();
                System.out.println("scheduleAtFixedRate 执行花费时间=" + (end - start) / 1000 + "m");
                System.out.println("scheduleAtFixedRate 执行完成时间：" + DateFormat.getTimeInstance().format(new Date()));
                System.out.println("======================================");
            }
        }, 1, 5, TimeUnit.SECONDS);
    }
}
