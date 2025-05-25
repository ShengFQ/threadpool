package com.shengfq.juc.map;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ClassName: ConcurentHashMapTest
 * Description: TODO
 *
 * @author shengfq
 * @date: 2025/4/12 17:17
 */
public class ConcurrentHashMapTest {

    private static final ConcurrentHashMap<String, AtomicInteger> locks=new ConcurrentHashMap<>();

    public void start(String material){
        AtomicInteger ai= locks.putIfAbsent(material,new AtomicInteger(0));
        ai.incrementAndGet();
        //执行业务逻辑代码
        if(ai!=null && ai.getAndDecrement()==0){
            locks.remove(material,ai);
        }
    }
}
