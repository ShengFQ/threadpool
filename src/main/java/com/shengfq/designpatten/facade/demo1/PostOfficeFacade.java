package com.shengfq.designpatten.facade.demo1;

/**
 * ClassName: PostOfficeFacade Description: 门面类
 *
 * @author shengfq
 * @date: 2024/1/14 4:31 下午
 */
public class PostOfficeFacade {

  private final PostLetterProcess postLetterProcess;

  public PostOfficeFacade(final PostLetterProcess postLetterProcess) {
    this.postLetterProcess = postLetterProcess;
  }

  /**
   * 将发送邮件封装起来
   */
  public void post(final String context, final String address) {
      this.postLetterProcess.writeLetter(context);
      this.postLetterProcess.fillEmployee(address);
      this.postLetterProcess.letterIntoEmployee();
      this.postLetterProcess.send();
  }
}
