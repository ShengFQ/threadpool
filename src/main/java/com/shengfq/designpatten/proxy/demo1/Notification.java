package com.shengfq.designpatten.proxy.demo1;

/**
 * Created by sheng on 18/6/3.
 */
public class Notification implements Notify {
  @Override
  public void notification() {
    // System.out.println("aspect method:ex notification,exception handler,authentication
    // filter,logging,transaction");
    /*
     * Throwable ex = new Throwable(); StackTraceElement[] stackElements = ex.getStackTrace(); if
     * (stackElements != null) { for (int i = 0; i < stackElements.length; i++) {
     * System.out.println(stackElements[i].getClassName());
     * System.out.println(stackElements[i].getFileName());
     * System.out.println(stackElements[i].getLineNumber());
     * System.out.println(stackElements[i].getMethodName());
     * System.out.println("-----------------------------------"); } }
     */
  }

  @Override
  public void afterNofification() {
    System.out.println("aspect method:afterNofification");

  }

  @Override
  public void beginTransaction() {
    System.out.println("aspect method:beginTransaction");

  }

  @Override
  public void endTransaction() {
    System.out.println("aspect method:endTransaction");

  }
}
