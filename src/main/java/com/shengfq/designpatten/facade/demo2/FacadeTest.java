package com.shengfq.designpatten.facade.demo2;

/**
 * ClassName: TestFacade Description: 软考:软件设计师 2022年下半年,下午题
 *
 * @author shengfq
 * @date: 2024/1/14 5:23 下午
 */
public class FacadeTest {
  /**
   * 门面模式的优点:增加一个门面,对外提供一个简单接口,封装复杂的API调用过程,解耦生产者和消费者.
   */
  /**
   * 门面模式的应用场景:如果对于一个用户来需要调用许多细节来实现功能业务,这时候就要考虑增加一个门面来封装这些复杂的行为.
   */
  /**
   * 门面模式的设计元素: 抽象的处理器 抽象出一个处理器接口,将原来分散的业务类API都实现这个接口. 抽象的客户 抽象出一个客户,提供客户对应的入参 具体的门面器
   * 在门面器里依赖客户对象和处理器对象,实现对象和处理器的融合调用.
   */
  public static void main(final String[] args) {
    final Patient patient = new ConcretePatient("shengfq");
    final Facade facade = new Facade(patient);
    facade.dispose();
  }
}
