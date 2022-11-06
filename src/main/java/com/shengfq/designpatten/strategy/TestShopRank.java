package com.shengfq.designpatten.strategy;

import cn.hutool.core.util.StrUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.Optional;

/**
 * ClassName: TestShopRank
 * Description: TODO
 *
 * @author shengfq
 * @date: 2022/11/5 11:14 上午
 */
public class TestShopRank {
    ShopRankHandlerFactory shopRankHandlerFactory;

    public TestShopRank(){
        //获取上下文容器对象,初始化工厂对象
        ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");
        shopRankHandlerFactory= ap.getBean("shopRankHandlerFactory",ShopRankHandlerFactory.class);
    }

    //version 1 根据参数调用对应的算法计算店铺等级
    public String acqurireShopRank1(String shopType) {
        String rank ="";
        if (Objects.equals("淘宝", shopType)) {
            // 获取淘宝店铺等级计算策略类
            ShopRankHandler shopRankHandler = new TbShopRankHandleImpl();
            // 计算店铺等级
            rank = shopRankHandler.calculate();
        } else if (Objects.equals("天猫", shopType)) {
            // 获取天猫店铺等级计算策略类
            ShopRankHandler shopRankHandler = new TmShopRankHandleImpl();
            // 计算店铺等级
            rank = shopRankHandler.calculate();
        } else if (Objects.equals("淘特", shopType)) {
            // 获取淘特店铺等级计算策略类
            ShopRankHandler shopRankHandler = new TtShopRankHandleImpl();
            // 计算店铺等级
            rank = shopRankHandler.calculate();
        } else {
            //  ...
        }
        return rank;
    }

    //version 2实现自动匹配对象,客户端无需更改任何代码
// 根据参数调用对应的算法计算店铺等级
    public String acqurireShopRank2(String shopType) {
        ShopRankHandler shopRankHandler = shopRankHandlerFactory.getStrategy(shopType);
        return Optional.ofNullable(shopRankHandler)
                .map(shopRankHandle -> shopRankHandle.calculate())
                .orElse(StrUtil.emptyIfNull(""));
    }

    public static void main(String[] args) {
        TestShopRank testShopRank=new TestShopRank();
        String rank=testShopRank.acqurireShopRank2("飞猪");
        System.out.println(rank);
    }
}
