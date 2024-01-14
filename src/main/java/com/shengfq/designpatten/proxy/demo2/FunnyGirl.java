package com.shengfq.designpatten.proxy.demo2;

/**
 * ClassName: Xishi Description: 西施
 *
 * @author shengfq
 * @date: 2024/1/14 2:51 下午
 */
public class FunnyGirl implements BeautifulWomen {
  /**
   * 代理行为1
   */
  @Override
  public void danceWithMan() {
    System.out.println("西施起舞");
  }

  /**
   * 代理行为2
   */
  @Override
  public void happyWithMan() {
    System.out.println("与西施共度春宵");
  }
}
