package com.shengfq.concurrent;

/**
 * @author sheng
 * @desc java内存模型共享变量的读写
 * @date 2020-08-05
 * java程序中各种变量的访问规则
 * 全局变量
 * 静态变量(类变量) --主内存
 * 实例变量 --主内存
 * 基本变量
 * volatile变量(保证数据的可见性,但是不保证原子性)
 * synchronized是一种排他的机制.
 * 局部变量 ---线程私有工作内存
 */
public class JMMDemo {
    public static void main(String[] args) {
        useVolatile();
    }

    /**
     * demo1
     * 主线程访问子线程中的变量域
     * 结果始终是无法打印该变量
     */
    private static void accessSunThreadVar() {
        Aobing a = new Aobing();
        a.start();
        for (; ; ) {
            if (a.isFlag()) {
                System.out.println("Aobing flag is true");
            }
        }
    }

    /**
     * demo2
     * 因为某一个线程进入synchronized代码块前后，线程会获得锁，清空工作内存，
     * 从主内存拷贝共享变量最新的值到工作内存成为副本，执行代码，将修改后的副本的值刷新回主内存中，线程释放锁。
     */
    private static void addLock() {
        Aobing a = new Aobing();
        a.start();
        for (; ; ) {
            synchronized (a) {
                if (a.isFlag()) {
                    System.out.println("Aobing flag is true");
                }
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {

            }
        }
    }
    /**
     * demo3
     * 使用volatile关键字修饰共享变量
     *
     * volatile修饰符适用于以下场景：某个属性被多个线程共享，其中有一个线程修改了此属性，
     * 其他线程可以立即得到修改后的值，比如booleanflag;或者作为触发器，实现轻量级同步。
     *
     * volatile属性的读写操作都是无锁的，它不能替代synchronized，因为它没有提供原子性和互斥性。
     * 因为无锁，不需要花费时间在获取锁和释放锁_上，所以说它是低成本的。
     * */
    public static void useVolatile() {
        Aobing a = new Aobing();
        a.start();
        for (; ; ) {
            if (a.isFlag()) {
                System.out.println("Aobing flag is true");
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {

            }
        }
    }

    /**
     * 子线程私有工作内存案例
     */
    static class Aobing extends Thread {
        /**
         * demo 3 volatile修饰
         */
        volatile boolean flag;

        public boolean isFlag() {
            return flag;
        }

        @Override
        public void run() {
            /*try{
                Thread.sleep(2000);
            }catch(InterruptedException e){

            }*/
            flag = true;
            System.out.println("flag =" + flag);
        }
    }
}
