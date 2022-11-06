package com.shengfq.pool4;
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
    //定义任务
   private ITask task=new ITask() {
        @Override
        public void executeTask() {
            System.out.println("开始执行异步任务 thread:"+Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
   //定义回调
   private ICallback callback=new ICallback() {
       @Override
       public void callback(boolean isSuccess) {
           System.out.println("异步任务完成,执行回调 thread:"+Thread.currentThread().getId());
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
   };

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            TaskTest test=new TaskTest();
            ExecuteTaskUtils.submitTask(test.task,test.callback);
        }
        System.out.println("主线程结束!");
    }
}
