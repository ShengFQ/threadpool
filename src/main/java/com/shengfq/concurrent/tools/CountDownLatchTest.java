package com.shengfq.concurrent.tools;

import java.util.concurrent.CountDownLatch;

/**
 * ClassName: ThreadTj
 * Description: 线程统计
 * 我们要实现的目标是：A、B、C三个线程可以同时开始运行，各自独立运行完成后通知D；
 * D 不会开始运行，直到 A、B 和 C 都运行完毕。所以我们 CountdownLatch 用来实现这种类型的通信。它的基本用法是：
 * @author shengfq
 * @date: 2023/4/1 4:50 下午
 */
public class CountDownLatchTest {
    /**
     * abc并发执行共计1秒,D运行1秒,共计2秒.
     *CountDownLatch适用于一个线程需要等待多个线程的情况。
     * 其实CountDownLatch它本身就是一个倒数计数器，我们把初始的count值设置为3。D运行的时候，首先调用该countDownLatch.await()方法检查计数器的值是否为0，如果不是0则保持等待状态. A、B、C 运行完毕后，分别使用countDownLatch.countDown()方法将倒数计数器减1。计数器将减为 0，然后通知await()方法结束等待，D开始继续执行。
     * */
    public static void main(String[] args) {
        int count=6;
        CountDownLatch countDownLatch=new CountDownLatch(count);
        Thread D=new Thread(()->{
            System.out.println("D等待其他线程执行完成");
            try {
                countDownLatch.await();
                System.out.println("D开始运行");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        for(char threadName='a';threadName<='f';threadName++){
            final String name=String.valueOf(threadName);
            Thread t=new Thread(()->{
                System.out.println(name+"正在运行");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
            t.start();
        }
        D.start();
    }
}
