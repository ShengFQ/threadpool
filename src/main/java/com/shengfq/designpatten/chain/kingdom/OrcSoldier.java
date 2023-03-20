
package com.shengfq.designpatten.chain.kingdom;

import org.springframework.stereotype.Service;

/**
 *
 * OrcSoldier 只能处理COLLECT_TAX 的任务,其他无法处理
 *
 */
@Service
public class OrcSoldier extends RequestHandler {


  @Override
  public void handleRequest(Request req) {
    if (req.getRequestType().equals(RequestType.COLLECT_TAX)) {
      printHandling(req);
      req.markHandled();
    } else {
      super.handleRequest(req);
    }
  }

  @Override
  public String toString() {
    return "大头兵";
  }
}
