package com.shengfq.pool3;

import java.util.concurrent.Callable;

/**
 * 一个异步耗时统计任务
 * @author sheng
 * @version 1.0
 * @date 2022/4/20 下午9:30
 */
public class Task<T extends Result> implements Callable {
    private T t;
    public Task(T t){
        this.t=t;
    }
    @Override
    public T call() throws Exception {
        try{
            System.out.println("thread:"+Thread.currentThread().getName());
            Thread.sleep(2000);
            t.setCount(10);
            t.setName(Thread.currentThread().getName());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return t;
    }
}
