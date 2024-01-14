package com.shengfq.designpatten.proxy.demo1;

/**
 * Created by sheng on 18/6/3.
 */
public interface Notify {
  void notification();

  void afterNofification();

  void beginTransaction();

  void endTransaction();
}
