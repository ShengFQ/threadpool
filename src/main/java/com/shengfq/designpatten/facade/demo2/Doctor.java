package com.shengfq.designpatten.facade.demo2;

/**
 * ClassName: Doctor Description: TODO
 *
 * @author shengfq
 * @date: 2024/1/14 5:19 下午
 */
public class Doctor implements Disposer {
  @Override
  public void dispose(final Patient patient) {
    System.out.println("i am diagnosing" + patient.getName());
  }
}
