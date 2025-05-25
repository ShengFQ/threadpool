package com.shengfq.lambda.functional;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: SortApple
 * Description:
 *
 * @author shengfq
 * @date: 2025/5/25 20:12
 */
public class SortApple {
    static List<Apple> list=new ArrayList<>();
    static{
        Apple apple1=new Apple("green",120);
        Apple apple2=new Apple("red",160);
        Apple apple3=new Apple("green",160);
        Apple apple4=new Apple("red",110);
        list.add(apple1);list.add(apple2);list.add(apple3);list.add(apple4);
    }
    public static void main(String[] args) {

    }


}
