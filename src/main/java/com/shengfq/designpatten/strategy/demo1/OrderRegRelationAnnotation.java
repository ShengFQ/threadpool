package com.shengfq.designpatten.strategy.demo1;

import java.lang.annotation.*;

/**
 * OrderRegRelationAnnotation keep 订单reg 的枚举
 *
 * @author chenkaimin
 * @Date 2023/7/12 17:05
 * @Description
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OrderRegRelationAnnotation {

  BizEnum.BizTypeEnum value();
}

