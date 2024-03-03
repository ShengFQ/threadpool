package com.shengfq.designpatten.strategy.demo1;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.ApplicationContext;
import cn.hutool.core.map.MapUtil;

/**
 * 处理策略的 处理工具的基本类
 *
 * @Date 2023/3/8 17:59
 */
public abstract class BaseStrategyHandler<T, R extends Annotation> {

  protected ApplicationContext applicationContext;

  public BaseStrategyHandler(final ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }

  /**
   * 容器
   */
  protected ConcurrentHashMap<String, Class<T>> container = new ConcurrentHashMap();

  /**
   * 返回指定的策略枚举
   */
  protected abstract Class<R> getStrategyAnnotationClass();

  /**
   * 返回指定的策略 接口类
   */
  protected abstract Class<T> getStrategyInterface();

  /**
   * 获取 注解的值 为了处理可能枚举值是数组的情况，因此需要包装成集合 为了避免多个策略键用的同一个策略实现的情况
   *
   * @date 17:41 2023/7/6
   * @param strategyAnnotationEntity 注解实体
   * @return java.util.List<java.lang.String>
   **/
  protected abstract List<String> getStrategyAnnotationValue(R strategyAnnotationEntity);

  /**
   * 根据class 获取Bean
   *
   * @param clazz
   * @return T
   * @date 17:06 2023/3/9
   **/
  protected T getBean(final Class<T> clazz) {
    return this.applicationContext.getBean(clazz);
  }

  /**
   * 获取类上的 枚举实体
   *
   * @date 17:44 2023/7/6
   * @param service 策略类实体
   * @return R 枚举实体
   **/
  protected R getStrategyAnnotationEntity(final Class<T> service) {
    final Class<R> strategyAnnotationClass = this.getStrategyAnnotationClass();
    final boolean annotationPresent = service.isAnnotationPresent(strategyAnnotationClass);
    return service.getAnnotation(strategyAnnotationClass);
  }

  /**
   * 懒加载的方式 初始化容器
   *
   * @date 17:50 2023/7/6
   * @param
   * @return void
   **/
  protected void lazyInitContainer() {

    final ConcurrentHashMap<String, Class<T>> container = this.container;
    // 获取策略接口
    final Class<T> strategyInterface = this.getStrategyInterface();
    // 获取所有 实现类的spring bean
      this.applicationContext.getBeansOfType(strategyInterface).forEach((k, v) -> {
      final Class<T> service = (Class<T>) v.getClass();
      // 获取策略实体上的枚举实体
      final R strategyAnnotationEntity = this.getStrategyAnnotationEntity(service);
      // 获取枚举上的值
      final List<String> strategyAnnotationValue =
          this.getStrategyAnnotationValue(strategyAnnotationEntity);
      // 置入策略容器
      strategyAnnotationValue.stream().forEach(value -> container.putIfAbsent(value, service));
    });
  }

  /**
   * 获取策略实体 供外部调用的
   *
   * @date 17:44 2023/7/6
   * @param strategyKey
   * @return java.lang.Class<T>
   **/
  public T getStrategyEntity(final String strategyKey) {
    // 获取容器
    final ConcurrentHashMap<String, Class<T>> container = this.container;
    if (MapUtil.isEmpty(container)) {
      this.lazyInitContainer();
    }
    return this.getBean(container.get(strategyKey));
  }
}

