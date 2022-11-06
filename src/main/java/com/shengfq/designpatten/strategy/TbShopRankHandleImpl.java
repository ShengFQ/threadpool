package com.shengfq.designpatten.strategy;

import org.springframework.stereotype.Component;

/**
 * 淘宝店
 * 店铺等级计算策略实现类
 * */
@Component
public class TbShopRankHandleImpl implements ShopRankHandler{
    /**
     * 获取店铺类型的方法，接口的实现类需要根据各自的枚举类型来实现，后面就不贴出实现类的代码
     *
     * @return 店铺等级
     */
    @Override
    public String getType() {
        return "淘宝";
    }

    @Override
    public String calculate() {
        // 具体计算逻辑
        return "淘宝的业务逻辑";
    }
}
