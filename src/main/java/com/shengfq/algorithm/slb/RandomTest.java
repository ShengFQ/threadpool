package com.shengfq.algorithm.slb;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
/**
 * 随机轮询
 * 负载均衡算法
 * @author shengfq
 * */
public class RandomTest {

    private static final List<String> servers = Arrays.asList("192.168.1.1", "192.168.1.2", "192.168.1.3", "192.168.1.4");

    public static String getServer() {
        Random random = new Random();
        int index = random.nextInt(servers.size());
        return servers.get(index);
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String server = getServer();
            System.out.println("select server: "+server);
        }
    }
}
