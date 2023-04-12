package com.shengfq.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.CountDownLatch;

/**
 * ClassName: SimpleDateFormatTest
 * Description: 在阿里Java开发规约中，有强制性的提到SimpleDateFormat 是线程不安全的类 ，在使用的时候应当注意线程安全问题
  解决办法有三个:
    1.对共享对象加锁访问, synchronized(simpleDateFormat)
    2.不使用全局simpleDateFormat对象,而是局部每次都创建simpleDateFormat
    3.ThreadLocal构造线程安全的simpleDateFormat对象
    4.使用DateTimeFormatter
 * @author shengfq
 * @date: 2023/4/7 3:07 下午
 */
public class SimpleDateFormatTest {
    Object object=new Object();
    //禁止使用全局静态对象进行格式化
    private static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("YYYY-MM-dd");
    //线程不安全的访问
    public static String format1() {
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        return (simpleDateFormat.format(Calendar.getInstance().getTime()));
    }


    public static void main(String[] args) throws InterruptedException {
        SimpleDateFormatTest test=new SimpleDateFormatTest();
        test.fixThreadSafe1();
    }
    /**
     * 多线程环境下使用SimpleDateFormat存在安全问题
     * java.lang.NumberFormatException: multiple points
     * */
    public  void  threadNotSafe(){
        for (int i = 1; i < 31; i++) {
            int ii = i;
            new Thread(() -> {
                Date date = null;
                try {
                    String s = "2019-05-" + ii;
                    date = simpleDateFormat.parse(s);
                    System.out.println("" + ii + ":" + date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    /***
     * 线程安全访问,是因为加了对象锁控制
     * */
    public  void fixThreadSafe1(){
        for (int i = 1; i < 31; i++) {
            final int d = i;
            new Thread(() -> {
                Date date = null;
                try {
                    String s = "2023-04-" + d;
                    synchronized (object) {
                        date = simpleDateFormat.parse(s);
                    }
                    System.out.println("" + d + ":" + date.getDate());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
    /**
     * 线程安全访问,是使用的局部对象,不存在共享变量
     * */
    public  void fixThreadSafe2(){
        for (int i = 1; i < 31; i++) {
            int ii = i;
            new Thread(() -> {
                Date date = null;
                try {
                    String s = "2019-05-" + ii;
                    date = new SimpleDateFormat("yyyy-MM-dd").parse(s);
                    System.out.println("" + ii + ":" + date.getDate());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
    CountDownLatch countDownLatch =new CountDownLatch(100);
    /**
     * 线程安全访问
     * 用 ThreadLocal 来实现其实是有点类似于缓存的思路，每个线程都有一个独享的对象，避免了频繁创建对象，也避免了多线程的竞争。
     * */
    private  void fixThreadSafe3() throws InterruptedException {
        //定义一个线程安全的HashSet
        Set<String> dates = Collections.synchronizedSet(new HashSet<String>());
        for (int i = 0; i < 100; i++) {
            //获取当前时间
            Calendar calendar = Calendar.getInstance();
            int finalI = i;
           new Thread(() -> {
                //时间增加
                calendar.add(Calendar.DATE, finalI);
                //通过simpleDateFormat把时间转换成字符串
               // String dateString = simpleDateFormat.format(calendar.getTime()); //线程不安全
                String dateString=df.get().format(calendar.getTime());//线程安全
                //把字符串放入Set中
                dates.add(dateString);
                //countDown
                countDownLatch.countDown();
            }).start();
        }
        //阻塞，直到countDown数量为0
        countDownLatch.await();
        //输出去重后的时间个数
        System.out.println(dates.size());
    }


    public static String format(Date date){
        return new SimpleDateFormat("YYYY-MM-dd").format(date);//做下优化
    }

    public static String format1(Date date){
        return new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(date);//做下优化
    }
    /**
     * 线程安全对象
     * */
    public static String format2(LocalDateTime date){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy年MM月dd日 hh:mm a");
        String nowStr = date .format(format);
        return nowStr;
    }

    /**
     *
     * 线程安全的访问 SimpleDateFormat对象
    */
    private static final ThreadLocal<DateFormat> df=new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };
}
