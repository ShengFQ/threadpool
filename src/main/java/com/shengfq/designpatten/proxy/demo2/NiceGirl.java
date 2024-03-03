package com.shengfq.designpatten.proxy.demo2;

/**
 * ClassName: Diaochan Description: 漂亮女人的实例
 *
 * @author shengfq
 * @date: 2024/1/14 2:50 下午
 */
public class NiceGirl extends ProxyMan {

  /**
   * 代理行为1
   */
  @Override
  public void danceWithMan() {
    System.out.println("貂蝉起舞");
  }

  /**
   * 代理行为2
   */
  @Override
  public void happyWithMan() {
    System.out.println("与貂蝉共度春宵");
  }
}
