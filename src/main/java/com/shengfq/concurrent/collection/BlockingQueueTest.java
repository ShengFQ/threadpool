package com.shengfq.concurrent.collection;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {
    private static final BlockingQueue blockingQueue = new ArrayBlockingQueue(20);

    private static void putQueue() throws InterruptedException {
        Thread pThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Random rand = new Random(1);
                int temp;
                try {
                    while (blockingQueue.size() < 20) {
                        temp = (int) (1000 * rand.nextFloat());
                        System.out.println("pThread 放入: " + temp);
                        blockingQueue.put(temp);
                        System.out.println("pThread读到blockingQueue当前有" + blockingQueue.size() + "个元素");
                        Thread.sleep(100);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        });
        pThread.start();
      //  pThread.join();

    }

    public  static void takeQueue(){
        Thread cThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Object obj;
                try {
                    //只要有就一直取
                    while ((obj = blockingQueue.take()) != null) {
                        //take方法会一直阻塞直到有元素可拿
                        Thread.sleep(300);
                        System.out.println(Thread.currentThread().getName()+"--cThread拿到了：" + obj);
                        System.out.println(Thread.currentThread().getName()+"--cThread读到blockingQueue当前有" + blockingQueue.size() + "个元素");
                        if (0 == blockingQueue.size()){
                            break;
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        cThread.start();
        // cThread.join();
    }
    public static void main(String[] args) throws InterruptedException {
        putQueue();
        for (int i = 0; i < 100; i++) {
            takeQueue();
        }
        System.out.println("最后，blockingQueue当前有: " + blockingQueue.size() + "个元素");
    }
}
