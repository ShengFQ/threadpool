package com.shengfq.designpatten.proxy.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by sheng on 18/6/3.
 */
public class Test {
  public static void main(final String[] args) {
    proxy();
  }

  public static void proxy() {
    // 通过动态代理方法,使用代理类构造一个实例对象
    final Notify notify = new Notification();
    final RealSubject realSubject = new RealSubject();
    final Subject subject = (Subject) Proxy.newProxyInstance(realSubject.getClass().getClassLoader(),
        realSubject.getClass().getInterfaces(), new SubjectHandler(realSubject, notify));
    subject.sayHello();
    subject.doWork();

    /*
     * WSubject wSubject=new WSubject(); Subject
     * wsubject=(Subject)Proxy.newProxyInstance(wSubject.getClass().getClassLoader(),wSubject.
     * getClass().getInterfaces(),new SubjectHandler(wSubject)); wsubject.sayHello();
     */

  }

  public static void noProxy() {
    // 直接通过实现类构造一个实例对象
    final Subject subject = new RealSubject();
    subject.sayHello();
  }

  static class SubjectHandler implements InvocationHandler {
    Subject object;
    Notify notify;

    public SubjectHandler(final Subject subject, final Notify notify) {
      this.object = subject;
      this.notify = notify;
    }

    @Override
    public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
      // 所有的方法都会加上事务处理
      // notify.beginTransaction();
      // method.invoke(object,args);
      // notify.afterNofification();
      if (method.getName().contains("sayHello")) {
          this.notify.notification();
        method.invoke(this.object, args);
      }

      return null;
    }
  }
}
