
package com.shengfq.designpatten.chain;

/**
 *
 * OrcCommander 只能处理DEFEND_CASTLE的任务,其他任务无法处理
 *
 */
public class OrcCommander extends RequestHandler {

  public OrcCommander(RequestHandler handler) {
    super(handler);
  }

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
