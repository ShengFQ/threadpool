package com.shengfq.thread1;

import java.util.concurrent.TimeUnit;

/***
 * 线程间通信方式3 volatile 共享内存
 * */
public class Volatile implements Runnable{
    /**
     * volatile 线程间状态可见
     * */
    private static volatile boolean flag = true ;

    @Override
    public void run() {
        while (flag){
            System.out.println(Thread.currentThread().getName() + "正在运行。。。");
        }
        System.out.println(Thread.currentThread().getName() +"执行完毕");
    }

    public static void main(String[] args) throws InterruptedException {
        Volatile aVolatile = new Volatile();
        new Thread(aVolatile,"thread A").start();


        System.out.println("main 线程正在运行") ;

        TimeUnit.MILLISECONDS.sleep(1000) ;
        //主线程通过修改共享变量的状态达到通知作用
        aVolatile.stopThread();
        System.out.println("main 线程结束") ;
    }

    private void stopThread(){
        flag = false ;
    }
}
