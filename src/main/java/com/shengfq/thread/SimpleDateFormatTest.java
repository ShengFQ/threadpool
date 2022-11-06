package com.shengfq.thread;

import java.text.SimpleDateFormat;
/**
 * 线程不安全的日期格式化操作
 * https://mp.weixin.qq.com/s/Qz__lI8mJgZf1I46X-papQ
 * */
public class SimpleDateFormatTest {
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {

        /**
         * SimpleDateFormat线程不安全，没有保证线程安全(没有加锁)的情况下，禁止使用全局SimpleDateFormat,否则报错 NumberFormatException
         *
         * private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         */
        for (int i = 0; i < 20; ++i) {
            Thread thread = new Thread(() -> {
                try {
                    // 错误写法会导致线程安全问题
                    System.out.println(Thread.currentThread().getName() + "--" + SIMPLE_DATE_FORMAT.parse("2020-06-01 11:35:00"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "Thread-" + i);
            thread.start();
        }
    }
}
