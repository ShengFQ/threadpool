package com.shengfq.pool4;

import java.util.Random;

/***
 * @author sheng
 * 2022-07-25
 * 线程池测试
 * pools.execute(runnable)
 * class runnable{
 *     task.executeTask();
 *     callback.callback();
 * }
 * */
public class TaskTest {


    public static void main(String[] args) {
        testOOM();
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程结束!");
    }
    /**
     * 测试oom
     * */
    private static void testOOM(){
        while (true){
            exeTask();
        }
    }
    /**
     * 测试线程池执行异步任务和异步回调
     * */
    private static void testTask(){
        for (int i = 0; i < 100; i++) {
            exeTask();
        }
    }

    private static void exeTask(){
        ExecuteTaskUtils.submitTask(()->{
            boolean success=false;
            System.out.println("开始执行异步任务 thread:"+Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
                success=true;
                int s= new Random().nextInt(10);
                System.out.println("random:"+s);
                if(s>5){
                    success=false;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                success=false;
            }
            return success;
        },(success)->{
            String result="unknown";
            if(success) {
                System.out.println("异步任务完成,执行回调 thread:" + Thread.currentThread().getId());
                result="success";
            }else{
                System.out.println("异步任务失败,不执行回调 thread:" + Thread.currentThread().getId());
                result="fail";
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return result;
        });
    }
}
