package com.shengfq.concurrent.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 乐观锁案例
 * @author sheng
 * @date 2020-08-05
 *悲观锁适合写操作多的场景，先加锁可以保证写操作时数据正确。
 * synchronized
 * son of Lock
 * */
public class PositiveLock {
    /**
     * 共享变量
     * */
    private  volatile Integer count=0;
    /**
     * 可重入锁
     * */
    private ReentrantLock reentrantLock=new ReentrantLock();

    public static void main(String[] args) {

        PositiveLock positiveLock=new PositiveLock();
        System.out.println("main Thread:count="+positiveLock.count);
        //testMethod count=1
        positiveLock.testThread();
        //MyThread instance  count:1
        //positiveLock.testMethod();
        //modifyPublicResource count=2
        //positiveLock.modifyPublicResource();
    }

    /**
     * 使用悲观锁
     * */
    private synchronized void testMethod(){
        //操作同步资源
        count++;
        System.out.println("testMethod count="+count);
    }

    /**
     * 使用悲观锁
     * */
    private void modifyPublicResource(){
        reentrantLock.lock();
        //操作同步资源
        count++;
        System.out.println("modifyPublicResource count="+count);
        reentrantLock.unlock();
    }
    /**
     * 并发访问共享资源
     * 不使用任何锁的情况下,多线程访问共享变量产生脏读数据
     * 使用volatile修饰共享变量,多线程写共享变量仍然产生脏读,状态不一致
     * 使用悲观锁synchronized 锁定共享变量的读写代码,多线程写共享变量仍然产生脏读
     * 使用可重入锁ReentrantLock,多线程写共享变量成为原子操作,共享变量没有脏读状态产生.
     * */
    private  void testThread(){
        for(int i=0;i<10;i++) {
            MyThread thread = new MyThread();
            thread.start();
        }
    }

    /**
     * 子线程工作内存修改公共变量的副本
     * */
    class MyThread extends Thread{
        @Override
        public   void run() {
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            reentrantLock.lock();
            count++;
            System.out.println("MyThread instance  count:"+count);
            reentrantLock.unlock();
        }
    }
}
