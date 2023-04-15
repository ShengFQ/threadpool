package com.shengfq.algorithm.slb;

import java.util.Arrays;
import java.util.List;

/**
 * 负载均衡算法
 * hash计算因子
 * @author shengfq
 * @date: 2023/4/15 4:28 下午
 */
public class HashTest {

    private static final List<String> servers = Arrays.asList("192.168.1.1", "192.168.1.2", "192.168.1.3", "192.168.1.4");

    public static String getServer(String key) {
        int hash = key.hashCode();
        int index =  hash%servers.size();
        return servers.get(index);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String server = getServer(String.valueOf(i));
            System.out.println("select server: "+server);
        }
    }
}
