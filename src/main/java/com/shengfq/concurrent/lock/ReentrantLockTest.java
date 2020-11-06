package com.shengfq.concurrent.lock;
/**
 * 可重入锁
 * @author sheng
 * @date 2020-08-06
 *
 * */
public class ReentrantLockTest {

    /**
     * ReentrantLock 可重入锁 独享锁
     * */

    /**
     * ReadWriteLock 读锁是共享锁,写锁是独享锁
     * 独享锁与共享锁也是通过AQS来实现的，通过实现不同的方法，来实现独享或者共享。
     * **/
    public static void main(String[] args) throws Exception{
        ReentrantLockTest test=new ReentrantLockTest();
        test.setA();
        test.setB();
    }

    /**
     * synchronized 是声明可重入锁
     * 对于Synchronized而言，当然是独享锁。
     * */
    synchronized void setA() throws Exception{
        System.out.println("setA");
        Thread.sleep(1000);
        setB();
        /*for(;;){
            System.out.println("setA");
        }*/
    }
    /**
     *
     * */
    synchronized void setB() throws Exception{
        System.out.println("setB");
        Thread.sleep(1000);
        /*for(;;){
            System.out.println("setB");
        }*/
    }
}
