package com.shengfq.designpatten.decorator;
/**
 * decorator 装饰器模式案例
 * 通知接口
 * 本案例实现在不修改旧有系统的实现的基础上做增强
 * @author shengfq
 * */
public interface Notifier {
    /**
     * 发送消息
     * */
    void  send(IMessage message);
}
