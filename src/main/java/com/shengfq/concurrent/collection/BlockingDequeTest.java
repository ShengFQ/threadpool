package com.shengfq.concurrent.collection;

import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicLong;

public class BlockingDequeTest {
    private static final BlockingDeque blockingDeque = new LinkedBlockingDeque();
    private static final CountDownLatch latch = new CountDownLatch(1);
    private static final AtomicLong ATOM_INT = new AtomicLong(100L);
    private static final String ALL_LETTERS = "abcdefghijklmnopqrstuvwxyz";

    private static void testBlockingDeque() throws InterruptedException {
        Thread lrThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    latch.await();
                    while (true) {
                        Object obj = blockingDeque.pollFirst();
                        if (obj != null) {
                            System.out.println("lrThread gets: [" + obj + "] from Deque");
                            if (ATOM_INT.decrementAndGet() < 0L) {
                                System.out.println("lrThread: tired of this stupid game, BYE!");
                                break;
                            }
                        }
                        Thread.sleep(40);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        Thread lwThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    latch.await();
                    String str;
                    for (; ; ) {
                        str = genRandomStr();
                        blockingDeque.offerFirst(str);
                        System.out.println("lwThread writes: [" + str + "] to Deque");
                        if (ATOM_INT.longValue() < 0L) {
                            System.out.println("lwThread: I've got a bad feeling about this...");
                            break;
                        }
                        Thread.sleep(200);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread rrThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    latch.await();
                    while (true) {
                        Object obj = blockingDeque.pollLast();
                        if (null != obj) {
                            System.out.println("rrThread gets: [" + obj + "] from Deque");
                            if (ATOM_INT.decrementAndGet() < 0L) {
                                System.out.println("rrThread: OUT!");
                                break;
                            }
                        }
                        Thread.sleep(30);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread rwThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    latch.await();
                    String str;
                    for (; ; ) {
                        str = genRandomStr();
                        blockingDeque.addLast(str);
                        System.out.println("lwThread writes: [" + str + "] to Deque");
                        if (ATOM_INT.longValue() < 0L) {
                            System.out.println("rwThread: Ew!");
                            break;
                        }
                        Thread.sleep(150);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        lrThread.start();
        lwThread.start();
        rrThread.start();
        rwThread.start();
        latch.countDown();
        lrThread.join();
        lwThread.join();
        rrThread.join();
        rwThread.join();
        System.out.println("Finally, blockingDeque is: " + blockingDeque);
    }

    private static String genRandomStr() {
        Random ran = new Random();
        String tempStr = "";
        int idx1;
        for (int i = 0; i < 3; i++) {
            idx1 = Math.abs((int) (26 * ran.nextFloat()));
            tempStr += ALL_LETTERS.substring(idx1, idx1 + 1);
        }
        return tempStr + Math.abs((int) (10 * ran.nextFloat()));
    }

    public static void main(String[] args) throws InterruptedException {
        testBlockingDeque();
    }
}
