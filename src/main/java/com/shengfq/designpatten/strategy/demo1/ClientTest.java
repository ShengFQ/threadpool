package com.shengfq.designpatten.strategy.demo1;

import org.springframework.context.ApplicationContext;

import com.shengfq.designpatten.strategy.demo1.domain.OrderRegRelation;
import com.shengfq.designpatten.strategy.demo1.domain.OrderRegRelationSaveDto;

/**
 * ClassName: ClientTest Description: TODO
 *
 * @author shengfq
 * @date: 2024/2/1 6:22 下午
 */
public class ClientTest {

  public static Boolean saveOrderRegRelation(
      final OrderRegRelationSaveDto orderRegRelationSaveDto) {
    final ApplicationContext applicationContext = null;
    final OrderRegRelationStrategyHandler orderRegRelationStrategyHandler =
        new OrderRegRelationStrategyHandler(applicationContext);
    final OrderRegRelation orderRegRelation =
        orderRegRelationStrategyHandler.buildOrderRegRelation(orderRegRelationSaveDto);
    return true;
  }

}
