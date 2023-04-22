package com.shengfq.juc.threadlocal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 测试 ThreadLocal类的功能
 * */
public class TestThreadLocal {

    /**
     * 线程安全的访问 SimpleDateFormat对象
     */
    private static final ThreadLocal<DateFormat> df=new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    public static void main(String[] args) {
        test();
    }

    private static void test(){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i=1;i<31;i++){
            final int d=i;
                executorService.submit(() -> {
                    String str = "2023-04-" + d;
                    try {
                      Date date=  df.get().parse(str);
                      System.out.printf("%s : %s \n",d,date);
                    }catch (ParseException e){
                        e.printStackTrace();
                    }
                });
        }
        executorService.shutdown();
    }

}
