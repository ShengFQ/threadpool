
package com.shengfq.designpatten.chain.kingdom;

import org.springframework.stereotype.Service;

/**
 *
 * OrcOfficer 只能处理TORTURE_PRISONER,其他无法处理
 *
 */
@Service
public class OrcOfficer extends RequestHandler {


  @Override
  public void handleRequest(Request req) {
    if (req.getRequestType().equals(RequestType.TORTURE_PRISONER)) {
      printHandling(req);
      req.markHandled();
    } else {
      super.handleRequest(req);
    }
  }

  @Override
  public String toString() {
    return "典狱长";
  }

}
