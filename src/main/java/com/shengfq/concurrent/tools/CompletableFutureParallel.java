package com.shengfq.concurrent.tools;


import com.shengfq.concurrent.task.OrderInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
/**
 * 异步任务并发执行
 * @author shengfq
 * **/
public class CompletableFutureParallel {
    private static final int CORE_POOL_SIZE = 4;
    private static final int MAX_POOL_SIZE = 12;
    private static final long KEEP_ALIVE_TIME = 5L;
    private final static int QUEUE_SIZE = 1600;

    protected final static ExecutorService THREAD_POOL = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE,
            KEEP_ALIVE_TIME, TimeUnit.SECONDS, new LinkedBlockingQueue<>(QUEUE_SIZE));

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        OrderInfo orderInfo = new OrderInfo();
        //CompletableFuture 的List
        List<CompletableFuture> futures = new ArrayList<>();
        futures.add(CompletableFuture.runAsync(() -> {
            System.out.println("当前任务Customer,线程名字为:" + Thread.currentThread().getName());

        }, THREAD_POOL));
        futures.add(CompletableFuture.runAsync(() -> {
            System.out.println("当前任务Discount,线程名字为:" + Thread.currentThread().getName());

        }, THREAD_POOL));
        futures.add( CompletableFuture.runAsync(() -> {
            System.out.println("当前任务Food,线程名字为:" + Thread.currentThread().getName());

        }, THREAD_POOL));
        futures.add(CompletableFuture.runAsync(() -> {
            System.out.println("当前任务Other,线程名字为:" + Thread.currentThread().getName());

        }, THREAD_POOL));
        CompletableFuture allDoneFuture = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]));
        allDoneFuture.get(10, TimeUnit.SECONDS);
        System.out.println("main thread over");
        THREAD_POOL.shutdownNow();
    }
}
