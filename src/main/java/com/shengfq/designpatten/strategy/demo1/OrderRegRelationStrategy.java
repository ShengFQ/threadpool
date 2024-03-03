package com.shengfq.designpatten.strategy.demo1;

import com.shengfq.designpatten.strategy.demo1.domain.OrderRegRelation;
import com.shengfq.designpatten.strategy.demo1.domain.OrderRegRelationSaveDto;

/**
 * OrderRegRelationStrategy 订单reg 策略
 *
 * @Date 2023/7/12 17:19
 * @Description
 */
public interface OrderRegRelationStrategy {

  /**
   * 订单reg 实体需要的业务的实体的字段置入
   *
   * @date 17:43 2023/7/12
   * @param orderRegRelationSaveDto
   * @return com.central.keep.model.OrderRegRelation
   **/
  OrderRegRelation setEntityAttributes(OrderRegRelationSaveDto orderRegRelationSaveDto);
}

