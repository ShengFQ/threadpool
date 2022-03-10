package com.shengfq.designpatten.strategy;
/**
 * 策略模式的目的:将控制和算法逻辑解耦
 * 控制:线程调用
 * 算法逻辑:实际的业务代码
 * @author shengfq
 * @date 2021-12-02
 * */
public class ResourceB implements Strategy {

    public String getVpcList(String id) {
        System.out.println("B strategy"+"====="+id);
        return id;
    }

}
