package com.shengfq.concurrent.task;

import lombok.Data;

@Data
public class OrderInfo {
    ITask task;
    CustomerInfo customerInfo;

    public void doTask() {
        task.doTask();
    }
}
