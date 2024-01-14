package com.shengfq.designpatten.proxy.demo2;

/**
 * ClassName: ProxyMan Description: 代理人
 *
 * @author shengfq
 * @date: 2024/1/14 2:49 下午
 */
public class ProxyMan implements BeautifulWomen {
  /**
   * 被代理对象
   */
  private final BeautifulWomen beautifulWomen;

  public ProxyMan(final BeautifulWomen beautifulWomen) {
    this.beautifulWomen = beautifulWomen;
  }

  /**
   * 代理行为1 代理人自己不参与实际行为
   */
  @Override
  public void danceWithMan() {
    this.beautifulWomen.danceWithMan();
  }

  /**
   * 代理行为2 代理人自己不参与实际行为
   */
  @Override
  public void happyWithMan() {
    this.beautifulWomen.happyWithMan();
  }

}
