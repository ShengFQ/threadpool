package com.shengfq.synch;

/**
 * ClassName: LoggingWidget
 * Description: TODO
 *
 * @author shengfq
 * @date: 2025/4/3 22:25
 */
public class LoggingWidget extends Widget{
    @Override
    public synchronized void doSomething() {
        System.out.println("this is LoggingWidget doSomething");
        super.doSomething();
    }

    public static void main(String[] args) {
        LoggingWidget loggingWidget=new LoggingWidget();
       Thread t1=new Thread(new Runnable() {
           @Override
           public void run() {
               loggingWidget.doSomething();
               System.out.println("task done!");
           }
       });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                loggingWidget.doSomething();
                System.out.println("task done!");
            }
        });
        t1.start();
        t2.start();

    }

}
