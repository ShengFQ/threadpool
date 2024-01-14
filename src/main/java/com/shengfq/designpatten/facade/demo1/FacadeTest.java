package com.shengfq.designpatten.facade.demo1;

/**
 * ClassName: FacadeTest Description: 门面模式的测试
 *
 * @author shengfq
 * @date: 2024/1/14 4:33 下午
 */
public class FacadeTest {

  public static void main(final String[] args) {
    final PostOfficeFacade facade = new PostOfficeFacade(new LetterProcessImpl());
    facade.post("邮件", "地址");
  }
}
