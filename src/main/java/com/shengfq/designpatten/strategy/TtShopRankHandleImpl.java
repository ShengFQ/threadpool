package com.shengfq.designpatten.strategy;

import org.springframework.stereotype.Component;

@Component
public class TtShopRankHandleImpl implements ShopRankHandler{
    /**
     * 获取店铺类型的方法，接口的实现类需要根据各自的枚举类型来实现，后面就不贴出实现类的代码
     *
     * @return 店铺等级
     */
    @Override
    public String getType() {
        return "淘特";
    }

    @Override
    public String calculate() {
        // 具体计算逻辑
        return "淘特的业务逻辑";
    }
}
