
package com.shengfq.designpatten.chain.kingdom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 责任链处理器抽象类
 * 定义公共执行方法的实现
 * @author sheng
 * @date 2023-03-11
 * */
public abstract class RequestHandler implements IHandler{

  private static final Logger LOGGER = LoggerFactory.getLogger(RequestHandler.class);

  private IHandler next;

  @Override
  public void  setNext(IHandler next) {
    this.next = next;
  }

  /**
   * Request handler
   */
  @Override
  public void handleRequest(Request req) {
    if (next != null) {
      next.handleRequest(req);
    }
  }

  protected void printHandling(Request req) {
    LOGGER.info("{} handling request \"{}\"", this, req);
  }

  @Override
  public abstract String toString();
}
