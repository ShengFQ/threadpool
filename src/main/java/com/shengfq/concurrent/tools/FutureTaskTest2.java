package com.shengfq.concurrent.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * FutureTask也可以用作闭锁
 *
 * FutureTask是一个可取消的异步计算，实现了Runnable和Future接口，通常用来包装一个Callable对象，可以异步执行，并将计算结果返回调用主线程。
 * */
public class FutureTaskTest2 {
    private static AtomicInteger atomicInteger = new AtomicInteger(1);
    private static CountDownLatch countDownLatch = new CountDownLatch(3);

    private static void testFutureTask() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        List<FutureTask<Integer>> taskList = new ArrayList<FutureTask<Integer>>(10);

        for (int i = 0; i < 10; i++) {
            FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    countDownLatch.await();
                    Random ran = new Random();
                    int res = 0;
                    for (int j = 0; j < 10; j++) {
                        res += Math.abs(ran.nextInt() / 100);
                    }
                    int sleepSec = atomicInteger.getAndIncrement();
                    System.out.println("Thread-" + Thread.currentThread().getId() + " will run for " + sleepSec + " seconds");
                    Thread.sleep(1000 * sleepSec);
                    System.out.println("Thread-" + Thread.currentThread().getId() + " returns " + res);
                    return res;
                }
            });
            executor.submit(futureTask);
            taskList.add(futureTask);
        }

        countDownLatch.countDown();//3
        countDownLatch.countDown();//2
        countDownLatch.countDown();//1

        int totRes = 0;
        for (FutureTask<Integer> task : taskList) {
            totRes += task.get().intValue();
        }
        System.out.println("Final result: " + totRes);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        testFutureTask();
    }
}
