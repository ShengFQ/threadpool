package com.shengfq.designpatten.facade.demo1;

/**
 * ClassName: LetterProcessImpl Description: 具体的实现
 *
 * @author shengfq
 * @date: 2024/1/14 3:36 下午
 */
public class LetterProcessImpl implements PostLetterProcess {
  /**
   * 写信内容
   *
   * @param context
   */
  @Override
  public void writeLetter(final String context) {
    System.out.println("写信");
  }

  /**
   * 填地址
   *
   * @param address
   */
  @Override
  public void fillEmployee(final String address) {
    System.out.println("填地址");
  }

  /**
   * 打包裹
   */
  @Override
  public void letterIntoEmployee() {
    System.out.println("打包裹");
  }

  /**
   * 投递书信
   */
  @Override
  public void send() {
    System.out.println("投递书信");
  }
}
