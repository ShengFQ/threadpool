package com.shengfq.concurrent.tools;

import java.util.concurrent.CountDownLatch;
/***
 * 闭锁(CountDownLatch)
 * 闭锁是一种同步工具类，可以延迟线程的进度直到其到达中止状态。底层是基于 AQS（AbstractQueuedSynchronizer）实现，可以比join方法对线程有更灵活的控制。
 * */
public class TestHarness {
    public long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    try {
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException e) {
                    }
                }
            };
        }
        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        return end - start;
    }
}
