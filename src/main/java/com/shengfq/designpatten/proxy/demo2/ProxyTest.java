package com.shengfq.designpatten.proxy.demo2;

/**
 * ClassName: ProxyTest Description: 代理模式测试
 *
 * @author shengfq
 * @date: 2024/1/14 3:06 下午
 */
public class ProxyTest {
  public static void main(final String[] args) {
    // 被代理对象
    final FunnyGirl funnyGirl = new FunnyGirl();
    // 代理人对象
    final ProxyMan proxyMan = new ProxyMan(funnyGirl);
    proxyMan.danceWithMan();
    proxyMan.happyWithMan();
  }
}
