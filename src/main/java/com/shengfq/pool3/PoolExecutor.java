package com.shengfq.pool3;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * 执行器
 * */
public class PoolExecutor {
    static ExecutorService executor = Executors.newCachedThreadPool();
    static List<Shop> shops= Arrays.asList(new Shop("a"),
            new Shop("b"),
            new Shop("c"),
            new Shop("d"),
            new Shop("e"));

    public static void main(String[] args) throws Exception{
        System.out.println("main thread "+Thread.currentThread().getName());
        //主线程执行无阻塞异步任务
       // executeMultiTask();
        //主线程同步获取数据
        getPriceSync();

        testFindPrice();
    }
    /**
     * 执行异步任务
     * */
    public static Future<Result> executeAsyncTask() throws Exception{
        Result result=new Result();
        result.setCount(1);
        result.setName(Thread.currentThread().getName());
        Future<Result> future= executor.submit(new Task(result));
        //可以立即执行些耗时的其他任务,主线程空闲
        return future;
    }

    /**
     * 主线程执行无阻塞异步任务
     * */
    public static void executeMultiTask() throws Exception{
        Future<Result> future1=executeAsyncTask();
        Future<Result> future2=executeAsyncTask();
        Future<Result> future3=executeAsyncTask();
        //future.get() 阻塞当前主线程
        Result result1= future1.get(3, TimeUnit.SECONDS);
        System.out.println("result1:"+result1.toString());
        Result result2= future2.get(4, TimeUnit.SECONDS);
        System.out.println("result2:"+result2.toString());
        Result result3= future3.get(5, TimeUnit.SECONDS);
        System.out.println("result3:"+result3.toString());
        // 停止获取任务
        //future1.cancel(true);
      //  future2.cancel(true);
       // future3.cancel(true);
        //关闭线程池
        executor.shutdownNow();
    }

    /**
     * 异步获取价格
     * */
    public static void getPriceAsync()throws Exception{
        Shop shop =new Shop();
        long start = System.nanoTime();
        Future<Double> futurePrice= shop.getPriceAsync("abc");
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("异步调用 after " + invocationTime+ " msecs");
        System.out.println("执行其他任务.......");
        double price= futurePrice.get(10,TimeUnit.SECONDS);
        System.out.println("计算得到的价格是:"+price);
    }
    /**
     * 异步获取价格2
     * */
    public static void getPriceAsync2()throws Exception{
        Shop shop =new Shop();
        long start = System.nanoTime();
        Future<Double> futurePrice= shop.getPriceAsync2("abc");
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("异步调用 after " + invocationTime+ " msecs");
        System.out.println("执行其他任务.......");
        double price= futurePrice.get(10,TimeUnit.SECONDS);
        System.out.println("计算得到的价格是:"+price);
    }
    /**
     * 同步获取价格
     * */
    public static void getPriceSync()throws Exception{
        Shop shop =new Shop();
        long start = System.nanoTime();
        double price= shop.getPrice("abc");
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("同步调用 after " + invocationTime                                                  + " msecs");
        System.out.println("执行其他任务.......");
        System.out.println("计算得到的价格是:"+price);
    }


    /**
     * 对比同步流查找,并发任务查找,异步流查找的运行性能
     * */
    public static void testFindPrice(){
        PoolExecutor executor=new PoolExecutor();
        long start = System.nanoTime();
        List<String> list=executor.findPricesStream("myPhone27S");
        list.stream().forEach(System.out::println);
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("同步串行查找 in " + duration + " msecs");

        start = System.nanoTime();
        list=executor.findPricesParallelStream("myPhone27S");
        list.stream().forEach(System.out::println);
        duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("异步并行查找 in " + duration + " msecs");

        start = System.nanoTime();
        list=executor.findPricesFuture("myPhone27S");
        list.stream().forEach(System.out::println);
        duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("异步多线程查找 " + duration + " msecs");
    }

    /**
     * 串行查找流
     *  name: a price:0.4941127253209522
     *  name: b price:0.3263823926219048
     *  name: c price:0.22787070129682563
     *  name: d price:0.1855061368924672
     *  name: e price:0.21769717613545714
     * Done in 30122 msecs
     * */
    public List<String> findPricesStream(String products){
        return shops.stream().map(shop -> {
           return String.format(" name: %s price:%s",shop.getName(),shop.getPrice(products));
        }).collect(Collectors.toList());
    }
    /**
     * 使用并行流
     * main thread main
     *  name: a price:0.7683170044453257
     *  name: b price:0.5244135034797157
     *  name: c price:0.22392949238419424
     *  name: d price:0.2081231173944902
     *  name: e price:0.692518007532103
     * Done in 21117 msecs
     * */
    public List<String> findPricesParallelStream(String products){
        return shops.parallelStream().map(shop -> {
            return String.format(" name: %s price:%s",shop.getName(),shop.getPrice(products));
        }).collect(Collectors.toList());
    }
    /**
     * 异步查找
     * main thread main
     *  name: a price:0.961854386330246
     *  name: b price:0.9078416439539518
     *  name: c price:0.6036794524925747
     *  name: d price:0.5312129654695358
     *  name: e price:0.12068998170430256
     * Done in 21117 msecs
     * */
    public List<String> findPricesFuture(String products){
        List<CompletableFuture<String>> futures= shops.stream().map(shop -> CompletableFuture.supplyAsync(()->
                String.format(" name: %s price:%s",shop.getName(),shop.getPrice(products)))).collect(Collectors.toList());
        return futures.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }



}
