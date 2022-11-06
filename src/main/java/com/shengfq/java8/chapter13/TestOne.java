package com.shengfq.java8.chapter13;

import com.google.common.collect.Lists;
import com.sun.org.apache.bcel.internal.generic.FSUB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.LongStream;

/**
 * 函数式编程
 * demo:获得一个集合元素的所有子集
 * @author shengfq
 * @date 2022-06-12
 * */
public class TestOne {
    public static void main(String[] args) {
        TestOne testOne=new TestOne();
        /*List<Integer> list= Lists.newArrayList(1,2,9);
        List<List<Integer>> result=testOne.subsets(list);
        result.forEach(System.out::println);*/
        long result=testOne.factorialStreams(5);
        System.out.println("result:"+result);
    }
    /**
     * 获得一个集合元素的所有子集
     * []
     * [9]
     * [2]
     * [2, 9]
     * [1]
     * [1, 9]
     * [1, 2]
     * [1, 2, 9]
     * */
    public List<List<Integer>> subsets(List<Integer> list){
        if(list.isEmpty()){
            List<List<Integer>> ans=new LinkedList<>();
            ans.add(Collections.emptyList());
            return ans;
        }
        Integer first=list.get(0);
        List<Integer> rest=list.subList(1,list.size());
        List<List<Integer>> subans= subsets(rest);
        List<List<Integer>> subans2=insertAll(first,subans);
        return concat(subans,subans2);
    }

    public static List<List<Integer>> insertAll(Integer first, List<List<Integer>> lists) {
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> l : lists) {
            List<Integer> copyList = new ArrayList<>();
            copyList.add(first);
            copyList.addAll(l);
            result.add(copyList);
        }
        return result;
    }

    static List<List<Integer>> concat(List<List<Integer>> a, List<List<Integer>> b) {
        List<List<Integer>> r = new ArrayList<>(a);
        r.addAll(b);
        return r;
    }
    /**
     * 迭代式的阶乘结算
     * */
    static int factorialIterative(int n){
        int r=1;
        for(int i=1;i<=n;i++){
            r*=i;
        }
        return r;
    }
    /**
     * 递归式阶乘
     * 效率低
    **/
    static int factorialRecursive(int n){
        return n==1?1:n*(factorialRecursive(n-1));
    }
    /**
     * 函数式方式实现阶乘
     * */
    static long factorialStreams(int n){
        return LongStream.rangeClosed(1,n).reduce(1,(long a,long b) ->a*b);
    }
}
