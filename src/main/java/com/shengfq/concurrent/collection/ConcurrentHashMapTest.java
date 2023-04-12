package com.shengfq.concurrent.collection;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * 并发安全的集合测试
 * ConcurrentHashMap 测试验证
 * @author sheng
 * */
public class ConcurrentHashMapTest {
    /**
     * 如果是多线程并发写入Hashmap,随机出现如下异常
     * Exception in thread "Thread-0" java.util.ConcurrentModificationException
     * 遍历时，其他线程修改集合，导致计数器变化，再调用next或hasNext时可能会抛ConcurrentModificationException
     * */
    //private static final HashMap conHashMap = new HashMap();
    private static final ConcurrentHashMap conHashMap = new ConcurrentHashMap();
    private static CountDownLatch latch = new CountDownLatch(1);
    /**
     * 读线程
     * 每隔1秒遍历下集合
     * */
    public static void readMap() {
        Thread rThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    latch.await();
                    //每隔1秒遍历一次
                    Map.Entry entry;
                    while (true) {
                        System.out.println("***********************");
                        for (Object enObj : conHashMap.entrySet()) {
                            entry = (Map.Entry) enObj;
                            System.out.println("[Key=" + entry.getKey() + "]-[Value=" + entry.getValue() + "]");
                        }
                        System.out.println("***********************");
                        System.out.println("");
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        rThread.start();
    }
    /**
     * 写线程
     * 每隔10秒往集合里面写入1随机值
     * */
    public static void writeMap() {
        Thread wThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    latch.await();
                    //每隔10秒遍历一次
                    Random ran = new Random(1);
                    while (true) {
                        conHashMap.put("key" + (int) (ran.nextFloat() * 1000), Math.abs(ran.nextInt() * 1000));
                        Thread.sleep(100);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        wThread.start();
    }


    public static void main(String[] args) {
        readMap();
        for (int i = 0; i < 100; i++) {
            writeMap();
        }
        //latch作用是当子线程都结束再结束主线程
        latch.countDown();
        System.out.println("main thread was finished");
    }
}
