package com.shengfq.concurrent.collection;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
/**
 * 并发安全的集合,在高并发场景下,读写仍然是安全的没报错
 * @author shengfq
 * */
public class CopyOnWriteArrayListTest {
    /**
     * 如果是多线程并发写入ArrayList,随机出现如下异常
     * Exception in thread "Thread-0" java.util.ConcurrentModificationException
     * 遍历时，其他线程修改集合，导致计数器变化，再调用next或hasNext时可能会抛ConcurrentModificationException
     * */
   // private static final ArrayList cowList = new ArrayList();
    private static final CopyOnWriteArrayList cowList = new CopyOnWriteArrayList();
    private static CountDownLatch latch = new CountDownLatch(1);

    public static void readList() throws InterruptedException {
        Thread rThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    latch.await();
                    //每隔1秒遍历一次
                    while (true) {
                        System.out.println("***********************");
                        System.out.println("cowList is: " + cowList);
                        System.out.println("***********************");
                        System.out.println("");
                        Thread.sleep(1000);
                        /*if (cowList.size() > 10)
                            break;*/
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        rThread.start();
    }

    public static void writeList()  throws InterruptedException {
        Thread wThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    latch.await();
                    //每隔10秒遍历一次
                    Random ran = new Random(1);
                    while (true) {
                        cowList.add(ran.nextInt());
                        Thread.sleep(500);
                       /* if (cowList.size() > 10)
                            break;*/
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        wThread.start();

    }

    public static void main(String[] args) throws InterruptedException {
        readList();
        for (int i = 0; i < 100; i++) {
            writeList();
        }
        latch.countDown();
       // rThread.join();
      //  wThread.join();
        System.out.println("Finally, cowList is " + cowList);

    }
}
