package com.shengfq.pool5;

/**
 * ClassName: ThreadNotify
 * Description: 线程协作案例:让多个线程有序执行
 *
 * @author shengfq
 * @date: 2023/4/1 4:36 下午
 */
public class ThreadNotify {
    //1.通过对象锁,wait(),notify()实现线程间的信号协作
    private Object lock=new Object();
    Thread A =new Thread(()->{
        synchronized (lock){
            System.out.println("A1");
            try {
                lock.wait();//阻塞当前线程执行,然后交出锁的控制权
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("A2");
            System.out.println("A3");
        }
    });

    Thread B=new Thread(()->{
        //获取对象锁
        synchronized (lock){
            System.out.println("B1");
            System.out.println("B2");
            lock.notify();
            System.out.println("B3");
        }
    });

    public static void main(String[] args) {
        ThreadNotify test=new ThreadNotify();
        test.A.start();
        test.B.start();
    }

}
