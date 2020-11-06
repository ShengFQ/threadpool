package com.shengfq.pool2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;  
  
/** 
 * 生产者消费者客户端 
 *  
 * @author syz 
 * @date 2014-7-2 
 * @version v1.0.0 
 * @see com.gbcom.java.blockqueue.BlockingQueueClient 
 */  
public class BlockingQueueClient {  
  
    public static void main(String[] args) throws InterruptedException {  
        // 声明一个容量为10的缓存队列  
        BlockingQueue<String> queue = new LinkedBlockingQueue<String>(10);  
  
        Producer producer1 = new Producer(queue);  
        Producer producer2 = new Producer(queue);  
        Producer producer3 = new Producer(queue);  
        Consumer consumer = new Consumer(queue);  
        // 借助Executors  
        ThreadPoolExecutor service = (ThreadPoolExecutor) Executors  
                .newCachedThreadPool();  
        // 启动线程  
        service.execute(producer1);  
        service.execute(producer2);  
        service.execute(producer3);  
        service.execute(consumer);  
  
        // 执行10s  
        Thread.sleep(10 * 1000);  
  
        System.out.println("active count = " + service.getActiveCount());  
        Thread.sleep(2000);  
        // 退出Executor  
        service.shutdown();  
    }  
}  