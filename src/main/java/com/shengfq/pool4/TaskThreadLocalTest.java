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
public class TaskThreadLocalTest {


    public static void main(String[] args) {
        testOOM();
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

    private static void multiThreadTask(){
        for (int i = 0; i < 100; i++) {
            exeTask();
        }
    }
    /**
     * 线程池执行给 线程变量赋值
     * 1.只赋值,不移除,内存占用率会出现锯式
     * 2.赋值,取值后,移除
     * */
    private static void exeTask(){
           EssContextHolder.setSID(System.currentTimeMillis());
            System.out.printf("sid: %s \n",System.currentTimeMillis()+"");
            ExecuteTaskUtils.submitTask(()->{
                boolean success=false;
                System.out.println("开始执行异步任务 thread:"+Thread.currentThread().getId());
                try {
                    Thread.sleep(100);
                    Long sid=EssContextHolder.getSID();
                    success=true;
                    int s= new Random().nextInt(10);
                    System.out.printf("random: %d sid:%s \n",s,sid);
                    EssContextHolder.removeSid();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    success=false;
                }
                return success;
            });

    }
}
