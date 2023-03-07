package com.shengfq.pool4;


import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * 自定义线程池操作类
 * @author shengfq
 * */
class ExecuteTaskService {


    protected static ThreadPoolExecutor pools = null;

    /**
     * 提交任务请求
     * @param task
     */
    public void submitTask(Runnable task) {
        //有返回值
       Future<?> future= pools.submit(task);
        try {
           Object obj= future.get(100,TimeUnit.SECONDS);
            System.out.println("任务结束获得结果:"+obj);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        //无返回值
      //  pools.execute(task);
    }


    /**
     * 停止线程池
     */
    public void shutdown() {
        pools.shutdown();
    }


    /**
     * 初始化线下池
     */
    public ExecuteTaskService(){
         initPool(6,10);
    }

    /**
     * 初始化线下池
     */
    public ExecuteTaskService(int corePoolSize,int maxPoolSize){
        initPool(corePoolSize,maxPoolSize);
    }


    private void initPool(int corePoolSize,int maxPoolSize){
        ThreadFactory guavaThreadFactory = new ThreadFactoryBuilder().setNameFormat("task-pool-%d").build();
        pools = new ThreadPoolExecutor(corePoolSize, maxPoolSize, 10L,
                TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(1000),guavaThreadFactory, new ThreadPoolExecutor.CallerRunsPolicy());

    }
}
