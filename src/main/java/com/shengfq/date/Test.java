package com.shengfq.date;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.Collectors;

public class Test {
    public static class TestSimpleDateFormatThreadSafe extends Thread {
        @Override
        public void run() {
            while(true) {
                try {
                    this.join(2000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                System.out.println(this.getName() + ":" + DateUtil.parse("2019-01-10 00:00:00"));
            }
        }
    }
	public static void main(String[] args) {
        for(int i = 0; i < 3; i++){
            new TestSimpleDateFormatThreadSafe().start();
        }
	}
	/**
     *
     * */
	private static void testStringToDate() {
        String s = "2017-05-25";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(s);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(date);
	}
    /**
     * 查找当前日期 7天前的时间
     * 2021年12月15日11:10:04 7天前:Wed Dec 08 11:10:03 CST 2021
     * */
    private static void testCalendar(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -7);
       Date weekAgo= cal.getTime();
        System.out.println("a week ago:"+weekAgo);
    }

    private static void testCalendar2(){
        DateTime dateTime= DateUtil.offsetDay(new Date(),7);
        DateTime dateTime2= DateUtil.offsetDay(new Date(),-7);
        System.out.printf(" 今天: %s 7天后: %s  7天前: %s",new DateTime(),dateTime,dateTime2);
    }

    private static String formatString(String content){
        String regex="|||";
        if(!StrUtil.contains(content,regex)){
            return content;
        }
        String[] contArray= StrUtil.splitToArray(content,regex);
        String result= Arrays.stream(contArray).map(item->{ return "<p>"+item+"</p>";}).collect(Collectors.joining());
        return result;
    }

    private static String subString(String content){
       String value= StrUtil.subSuf(content,3);
       return value;
    }
}
