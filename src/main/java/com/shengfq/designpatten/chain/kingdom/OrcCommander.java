
package com.shengfq.designpatten.chain.kingdom;

/**
 *
 * OrcCommander 指挥官处理
 * 只能处理DEFEND_CASTLE的任务,其他任务无法处理
 *
 */
public class OrcCommander extends RequestHandler {


  @Override
  public void handleRequest(Request req) {
    if (req.getRequestType().equals(RequestType.DEFEND_CASTLE)) {
      printHandling(req);
      req.markHandled();
    } else {
      super.handleRequest(req);
    }
  }

  @Override
  public String toString() {
    return "指挥官";
  }
}
