package com.shengfq.designpatten.strategy;

import lombok.Getter;

public enum ShopTypeEnum {
    TAOBAO("A","淘宝"),
    TMALL("B", "天猫"),
    TAOTE("C", "淘特");

    @Getter
    private String type;
    @Getter
    private String desc;
    ShopTypeEnum(String type, String des) {
        this.type = type;
        this.desc = des;
    }
}
