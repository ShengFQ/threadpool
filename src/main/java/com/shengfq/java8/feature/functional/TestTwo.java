package com.shengfq.java8.feature.functional;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义函数式接口的测试
 * @author  shengfq
 * @date 2022-06-12
 * */
public class TestTwo {
    private static List<People> peopleList = new ArrayList<>();

    public static void init(){
        peopleList.add(new People("LuoTianyan",23));
        peopleList.add(new People("ff",26));
        peopleList.add(new People("Tony",33));
    }
    public static void main(String[] args) {
        init();
        testDefinedFunc();
    }


    public static void testDefinedFunc(){
        List<People> filter = Filter.filter(peopleList, p -> ((People) p).getAge() > 25);
        filter.forEach(System.out::println);
    }
}
