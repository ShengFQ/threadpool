package com.shengfq.collection;

import java.util.Arrays;
import java.util.List;

import cn.hutool.core.collection.ListUtil;

public class PartitionByHutoolExample {
    // 原集合
    private static final List<String> OLD_LIST = Arrays.asList(
            "唐僧,悟空,八戒,沙僧,曹操,刘备,孙权".split(","));

    public static void main(String[] args) {
        // 分片处理
        List<List<String>> newList = ListUtil.partition(OLD_LIST, 3);
        newList.forEach(i -> {
            System.out.println("集合长度：" + i.size());
        });
    }
}
