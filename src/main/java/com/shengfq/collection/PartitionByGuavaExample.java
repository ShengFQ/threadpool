package com.shengfq.collection;

import java.util.Arrays;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * Guava 分片
 */
public class PartitionByGuavaExample {
    // 原集合
    private static final List<String> OLD_LIST = Arrays.asList(
            "唐僧,悟空,八戒,沙僧,曹操,刘备,孙权".split(","));

    public static void main(String[] args) {
        // 集合分片
        List<List<String>> newList = Lists.partition(OLD_LIST, 3);
        // 打印分片集合
        newList.forEach(i -> {
            System.out.println("集合长度：" + i.size());
        });
    }
}
