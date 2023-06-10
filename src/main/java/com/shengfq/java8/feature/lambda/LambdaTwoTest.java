package com.shengfq.java8.feature.lambda;

/**
 * ClassName: LambdaTwoTest
 * Description: 匿名类和Lambda表达式
 *
 * @author shengfq
 * @date: 2023/6/10 6:35 下午
 */
public class LambdaTwoTest {
    /**
     * 定义一个匿名类对象
    */
    private static Runnable runnable=new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                String name=    Thread.currentThread().getName();
                System.out.println("t1 name:"+name);
            }
        }
    };
    /**
     * Lambda表达式实现函数式接口
     * */
    private static Runnable runnable2=()->{
        for (int i = 0; i < 10; i++) {
            String name=    Thread.currentThread().getName();
            System.out.println("t2 name:"+name);
        }
    };
    public static void main(String[] args) {
        Thread t1=new Thread(runnable);
        t1.start();

        Thread t2=new Thread(runnable2);
        t2.start();
    }
}
