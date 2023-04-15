package com.shengfq.concurrent.tools;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/**
 * 栅栏(Barrier)类似于闭锁，它能阻塞一组线程直到某个事件发生。栅栏与闭锁的关键区别在于，所有线程必须同时到达栅栏位置，才能继续执行。闭锁用于等待事件，而栅栏用于等待其他线程。
 *
 * CyclicBarrier可以使一定数量的参与方反复地在栅栏位置汇集，它在并行迭代算法中非常有用：这种算法通常将一个问题拆分成一系列互相独立的子问题。当线程到达栅栏位置时将调用await方法，这个方法将阻塞直到所有线程都到达栅栏位置。如果所有线程都到达了栅栏位置，那么栅栏将打开，此时所有线程都被释放，而栅栏将被重置以便下次使用。
 *
 * 另一种形式的栅栏是Exchanger，它是一种两方(Two-Party)栅栏，各方在栅栏位置上交还数据。
 * ————————————————
 * 版权声明：本文为CSDN博主「一条小龙」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/u011578173/article/details/93306631
 * */
public class BankRobbing {
    private static Random random = new Random();
    private static String CHICKEN_OUT = "";
    private CyclicBarrier TOUGH_TANK = new CyclicBarrier(5, new Runnable() {
        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(3L);
                System.out.println("Take a deep breath, guys..");
                TimeUnit.SECONDS.sleep(3L);
                System.out.println("Ok, let's go make some money!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    });

    private class BankRobber extends Thread {
        private String name;

        public BankRobber(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            int time;
            System.out.println("Criminal " + name + " setting off for TOUGH_TANK");
            try {
                time = Math.abs(random.nextInt() % 20);
                TimeUnit.SECONDS.sleep(time);
                System.out.println("Criminal " + name + " reaches TOUGH_TANK");
                if (time < 5 && "".equals(CHICKEN_OUT)) {
                    CHICKEN_OUT = name;
                    TOUGH_TANK.await(5, TimeUnit.SECONDS);
                } else {
                    TOUGH_TANK.await();
                }
                System.out.println("Go,go,go!!!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                System.out.println(CHICKEN_OUT + " chickens out, " + name + " flees...");
                //e.printStackTrace();
            } catch (TimeoutException e) {
                System.out.println(name + " can't bear the waiting......");
                //e.printStackTrace();
            }
        }
    }

    public void doRobBank() {
        String[] robbers = {"Carl", "Coughlin", "Ben", "Mike", "Douglas"};
        for (int i = 0; i < robbers.length; i++) {
            new BankRobber(robbers[i]).start();
        }
    }

    public static void main(String[] args) {
        BankRobbing bankRobbing = new BankRobbing();
        bankRobbing.doRobBank();
    }
}
