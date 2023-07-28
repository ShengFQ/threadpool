package com.shengfq.collection;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * JDK Stream Partition
 */
public class PartitionByStreamExample {
    // 原集合
    private static final List<Integer> OLD_LIST = Arrays.asList(
            1, 2, 3, 4, 5, 6);
    /**
     * 使用jdk自带的分组是只能通过bool表达式将原有数组分成2组
     * */
    public static void main(String[] args) {
        // 集合分片：将大于 3 和小于等于 3 的数据分别分为两组
        Map<Boolean, List<Integer>> newMap = OLD_LIST.stream().collect(
                Collectors.partitioningBy(i -> i > 3)
        );
        // 打印结果
        System.out.println(newMap);
    }
}
