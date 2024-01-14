package com.shengfq.designpatten.facade.demo1;

/**
 * 投递书信处理流程
 */
public interface PostLetterProcess {
  /**
   * 写信内容
   */
  void writeLetter(String context);

  /**
   * 填地址
   */
  void fillEmployee(String address);

  /**
   * 打包裹
   */
  void letterIntoEmployee();

  /**
   * 投递书信
   */
  void send();
}
