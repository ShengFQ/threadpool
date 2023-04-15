package com.shengfq.concurrent.tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 信号量(Semaphore)
 *
 * 计数信号量用来控制同时访问某个特定资源的操作数量，或者同时执行某个指定操作的数量。Semaphore可以用于实现资源池。
 *
 * 示例代码：
 */
public class PublicToilet {
    private static final int SPOTS = 5;
    private static final Random RANDOM = new Random();
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
    private static final Semaphore SEMAPHORE = new Semaphore(SPOTS, false); // Not a fair WC
    private static final AtomicInteger USE_TIMES = new AtomicInteger(0);

    private void startService() {
        for (int i = 0; i < 20; i++) {
            WcGoer goer = new WcGoer();
            goer.setErgentLevel((short) (RANDOM.nextInt() % 2));
            Thread thread = new Thread(new WcGoer());
            thread.start();
        }
    }

    private class WcGoer implements Runnable {
        private short ergentLevel;

        public short getErgentLevel() {
            return ergentLevel;
        }

        public void setErgentLevel(short ergentLevel) {
            this.ergentLevel = ergentLevel;
        }

        @Override
        public void run() {
            try {
                int useTime;
                if (ergentLevel == 0) {
                    SEMAPHORE.acquire();
                } else {
                    while (!SEMAPHORE.tryAcquire()) {
                        System.out.println(FORMAT.format(new Date()) + ":" + Thread.currentThread().getName() + " keep waiting");
                        Thread.sleep(1000 * 3);
                    }
                }
                System.out.println(FORMAT.format(new Date()) + ":" + Thread.currentThread().getName() + " enters WC" +
                        ((ergentLevel == 0) ? "" : " in a hurry"));
                useTime = Math.abs(RANDOM.nextInt() % 11);
                System.out.println(FORMAT.format(new Date()) + ":" + Thread.currentThread().getName() + " will use for " + useTime + " seconds");
                Thread.sleep(1000 * useTime);
                System.out.println(FORMAT.format(new Date()) + ":" + Thread.currentThread().getName() + " exits WC");
                SEMAPHORE.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void enterMaintenance() throws InterruptedException {
        //occupy all spots
        while (!SEMAPHORE.tryAcquire(SPOTS)) {
        }
        System.exit(0);
    }

    public static void main(String[] args) {
        PublicToilet pt = new PublicToilet();
        pt.startService();
    }

}
