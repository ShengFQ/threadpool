package com.shengfq.designpatten.facade.demo2;

/**
 * ClassName: Registry Description:
 *
 * @author shengfq
 * @date: 2024/1/14 5:17 下午
 */
public class Registry implements Disposer {
  @Override
  public void dispose(final Patient patient) {
    System.out.println("im registry" + patient.getName());
  }
}
