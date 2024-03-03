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
    FunnyGirl funnyGirl = new FunnyGirl();
    NiceGirl niceGirl = new NiceGirl();
    ProxyMan proxyMan=new ProxyMan();
    // 用户想要的,代理对象给
    BeautifulWomen women = proxyMan.getInstance(funnyGirl);
    women.danceWithMan();
    women.happyWithMan();
    women = proxyMan.getInstance(niceGirl);
    women.danceWithMan();
    women.happyWithMan();
  }
}
