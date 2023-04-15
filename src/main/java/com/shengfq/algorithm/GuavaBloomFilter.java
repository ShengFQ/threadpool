package com.shengfq.algorithm;


import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.util.Random;


/**
 * @author idea
 * @date created in 11:05 上午 2020/10/25
 */
public class GuavaBloomFilter {
    private static int bound=1000000;

    public static void main(String[] args) {
        //创建布隆过滤器时要传入期望处理的元素数量，及最期望的误报的概率。
        BloomFilter<Integer> bloomFilter = BloomFilter.create(
                Funnels.integerFunnel(),
                bound,  //希望存储的元素个数
                0.01  //希望误报的概率
        );
        for (int i = 0; i < bound; i++) {
            int random=new Random().nextInt(bound);
            bloomFilter.put(random);
        }
        //判断过滤器内部是否存在对应的元素
        System.out.println(bloomFilter.mightContain(1));
        System.out.println(bloomFilter.mightContain(2));
        System.out.println(bloomFilter.mightContain(-10000));
    }
}
