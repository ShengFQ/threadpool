package com.shengfq.juc.threadlocal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        for (int i=1;i<31;i++){
            final int d=i;
                new Thread(() -> {
                    String str = "2023-04-" + d;
                    try {
                      Date date=  df.get().parse(str);
                      System.out.printf("%s : %s \n",d,date.getDate());
                    }catch (ParseException e){
                        e.printStackTrace();
                    }
                }).start();
        }
    }

}
