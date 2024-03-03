package com.shengfq.designpatten.strategy.demo1;

import java.util.Collections;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.shengfq.designpatten.strategy.demo1.domain.OrderRegRelation;
import com.shengfq.designpatten.strategy.demo1.domain.OrderRegRelationSaveDto;


/**
 * OrderRegRelationStrategyHandler
 * 订单分发策略
 * @Date 2023/7/12 17:07
 * @Description
 */
@Component
public class OrderRegRelationStrategyHandler
    extends BaseStrategyHandler<OrderRegRelationStrategy, OrderRegRelationAnnotation> {

  /**
   * 初始化，提供spring的ApplicationContext spring在初始化bean时会将ApplicationContext
   **/
  public OrderRegRelationStrategyHandler(final ApplicationContext applicationContext) {
    super(applicationContext);
  }

  // 提供自定义注解类
  @Override
  protected Class<OrderRegRelationAnnotation> getStrategyAnnotationClass() {
    return OrderRegRelationAnnotation.class;
  }

  // 提供 策略接口类
  @Override
  protected Class<OrderRegRelationStrategy> getStrategyInterface() {
    return OrderRegRelationStrategy.class;
  }

  @Override
  protected List<String> getStrategyAnnotationValue(
      final OrderRegRelationAnnotation strategyAnnotationEntity) {
    return Collections.singletonList(strategyAnnotationEntity.value().getCode());
  }

  /**
   * 策略 handler 提供整体的逻辑处理，也可以写在 对应的 service层中
   *
   * @date 17:44 2023/7/12
   * @param orderRegRelationSaveDto
   * @return com.central.keep.model.OrderRegRelation
   **/
  public OrderRegRelation buildOrderRegRelation(
      final OrderRegRelationSaveDto orderRegRelationSaveDto) {
    // 获取策略类
    final OrderRegRelationStrategy strategyEntity =
        this.getStrategyEntity(orderRegRelationSaveDto.getBizType());

    // 策略实现类调用 实现的策略方法
    final OrderRegRelation orderRegRelation =
        strategyEntity.setEntityAttributes(orderRegRelationSaveDto);
    return orderRegRelation;
  }
}

