package com.shengfq.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: ListPartitionUtils
 * Description: 列表分片
 *
 * @author shengfq
 * @date: 2023/7/18 1:00 下午
 */
public class ListPartitionUtils {
    private static List<Integer> dataList=new ArrayList<>();

    static{
        for (int i = 0; i < 100; i++) {
            dataList.add(i);
        }
    }

    public static void main(String[] args) {
        List<Integer> result=PageUtil.splitQuery(dataList,(x)->{
            List<Integer> res= new ArrayList<>();
            res.addAll(x);
            return res;
        });

        int sum=result.stream().reduce(Integer::sum).get();
        System.out.println("sum:"+sum);
    }

}
