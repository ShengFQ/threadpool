package com.shengfq.concurrent.tools;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * ClassName: CyclicBarrierTest
 * Description: 三个运动员分开准备同时开跑
 *CyclicBarrier 的作用就是等待多个线程同时执行。
 * @author shengfq
 * @date: 2023/4/1 5:13 下午
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        System.out.println("main thread is running");
        runABCWhenAllReady();
        System.out.println("main thread run over");
    }


    public static void runABCWhenAllReady() {
        int count = 4;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(count);
        Random random = new Random();
        for (char threadName = 'A'; threadName <= 'D' ; threadName++) {
            final String name = String.valueOf(threadName);
            new Thread(() -> {
                int prepareTime = random.nextInt(10000);
                System.out.println(name + " 准备时间：" + prepareTime);
                try {
                    Thread.sleep(prepareTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name + " 准备好了，等待其他人");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(name + " 开始跑步");
            }).start();
        }
    }
}
