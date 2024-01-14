package com.shengfq.designpatten.facade.demo2;

/**
 * ClassName: ConcretePatient Description: 病人实现类
 *
 * @author shengfq
 * @date: 2024/1/14 5:23 下午
 */
public class ConcretePatient implements Patient {

  private final String name;

  public ConcretePatient(final String name) {
    this.name = name;
  }


  @Override
  public String getName() {
    return this.name;
  }
}
