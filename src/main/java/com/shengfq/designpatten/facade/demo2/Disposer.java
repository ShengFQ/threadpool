package com.shengfq.designpatten.facade.demo2;

/**
 * 医院看病模型,门面包装接口,将复杂流程封装到简单方法 package作用 中介服务
 */
public interface Disposer {

  void dispose(Patient patient);

}
