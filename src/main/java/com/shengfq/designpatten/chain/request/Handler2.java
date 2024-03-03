package com.shengfq.designpatten.chain.request;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Handler2 extends AbstractHandler {
    @Override
    public void handler(LeaveRequest request) {
        if (request.getDays() > 3 && request.getDays() <= 7) {
            log.info("经理 处理了 " + request.getEmployee() + " 的请假申请，天数为：" + request.getDays());
        }
    }
}
