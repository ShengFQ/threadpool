package com.shengfq.designpatten.facade.demo2;

/**
 * ClassName: Pharmacy Description: TODO
 *
 * @author shengfq
 * @date: 2024/1/14 5:20 下午
 */
public class Pharmacy implements Disposer {
  @Override
  public void dispose(final Patient patient) {
    System.out.println("i am giving medicine " + patient.getName());
  }
}
