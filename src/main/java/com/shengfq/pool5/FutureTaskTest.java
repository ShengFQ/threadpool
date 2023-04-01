package com.shengfq.pool5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * ClassName: FutureTaskTest
 * Description: 子线程将结果返回给主线程
 *
 * @author shengfq
 * @date: 2023/4/1 5:16 下午
 */
public class FutureTaskTest {

    public static void main(String[] args) {
        getResultInWorker();
    }
    public static void getResultInWorker() {
        Callable<Integer> callable = () -> {
            System.out.println("子任务开始执行");
            Thread.sleep(1000);
            int result = 0;
            for (int i = 0; i <= 100; i++) {
                result += i;
            }
            System.out.println("子任务执行完成并返回结果");
            return result;
        };
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();

        try {
            System.out.println("开始执行 futureTask.get()");
            Integer result = futureTask.get();//阻塞主线程
            System.out.println("执行的结果：" + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
