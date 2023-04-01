package com.shengfq.pool3;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * 订单
 * */
public class Shop {
    private String name;
    private double price;
    private String product;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Shop(String product){
        this.product=product;
        this.name=product;
        this.price=getPrice(product);
    }
    public Shop(){}
    /**
     * 同步计算-阻塞式
     * */
    public double getPrice(String product){
        return calculatePrice(product);
    }
    /**
     * 异步计算-非阻塞
     * */
    public Future<Double> getPriceAsync(String product){
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(()->{
            try {
                double price = calculatePrice(product);
                //计算完成,将结果放到future对象中,通过complate
                futurePrice.complete(price);
            }catch(Exception e){
                futurePrice.completeExceptionally(e);
            }
        }).start();
        return futurePrice;
    }
    /**
     * 异步计算-非阻塞
     * 工厂模式创建异步任务
     * */
    public Future<Double> getPriceAsync2(String product){
        //原理与上面是相同的,只不过下面是通过函数式接口+Lambda表达式实现
        return CompletableFuture.supplyAsync(()->calculatePrice(product));
    }
    /**
     * 计算商品价格
     * */
    public double calculatePrice(String product){
        delay();
        return new Random().nextDouble();
    }
    /**
     * 模拟耗时操作
     * */
    private void delay(){
        try{
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(3000);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
