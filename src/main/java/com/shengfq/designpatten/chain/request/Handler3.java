package com.shengfq.designpatten.chain.request;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Handler3 extends AbstractHandler {
    @Override
    protected void handler(LeaveRequest request) {
        if (request.getDays() > 7) {
            log.info("部门经理 处理了 " + request.getEmployee() + " 的请假申请，天数为：" + request.getDays());
        }
    }
}
