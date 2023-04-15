package com.shengfq.concurrent.tools;

import com.shengfq.concurrent.task.OrderInfo;

import java.util.concurrent.*;
/**
 * CountDownLatch 并行工具类
 * 方法的子任务在线程池并行执行,子任务完成,主任务再执行
 * 适用于将同步耗时任务改造为异步执行任务,前提是子任务之间没有依赖.
 * */
public class CountDownTask {
    private static final int CORE_POOL_SIZE = 4;
    private static final int MAX_POOL_SIZE = 12;
    private static final long KEEP_ALIVE_TIME = 5L;
    private final static int QUEUE_SIZE = 1600;

    protected final static ExecutorService THREAD_POOL = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE,
            KEEP_ALIVE_TIME, TimeUnit.SECONDS, new LinkedBlockingQueue<>(QUEUE_SIZE));
    public static void main(String[] args) throws InterruptedException {
        // 新建一个为5的计数器
        CountDownLatch countDownLatch = new CountDownLatch(6);
        OrderInfo orderInfo = new OrderInfo();
        THREAD_POOL.execute(() -> {
            System.out.println("当前任务Customer,线程名字为:" + Thread.currentThread().getName());

            countDownLatch.countDown();
        });
        THREAD_POOL.execute(() -> {
            System.out.println("当前任务Discount,线程名字为:" + Thread.currentThread().getName());

            countDownLatch.countDown();
        });
        THREAD_POOL.execute(() -> {
            System.out.println("当前任务Food,线程名字为:" + Thread.currentThread().getName());
          //  orderInfo.setFoodListInfo(new FoodListInfo());
            countDownLatch.countDown();
        });
        THREAD_POOL.execute(() -> {
            System.out.println("当前任务Tenant,线程名字为:" + Thread.currentThread().getName());
           // orderInfo.setTenantInfo(new TenantInfo());
            countDownLatch.countDown();
        });
        THREAD_POOL.execute(() -> {
            System.out.println("当前任务OtherInfo,线程名字为:" + Thread.currentThread().getName());
          //  orderInfo.setOtherInfo(new OtherInfo());
            countDownLatch.countDown();
        });
        countDownLatch.await(1, TimeUnit.SECONDS);
        System.out.println("主线程："+ Thread.currentThread().getName());
        THREAD_POOL.shutdownNow();
    }

}
