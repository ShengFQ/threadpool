package com.shengfq.designpatten.chain.request;

import lombok.Getter;

@Getter
public class LeaveRequest {
    private final String employee;
    private final int days;

    public LeaveRequest(String employee, int days) {
        this.employee = employee;
        this.days = days;
    }

}
