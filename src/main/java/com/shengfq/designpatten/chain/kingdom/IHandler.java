package com.shengfq.designpatten.chain.kingdom;
/**
 * 责任链处理器抽象接口
 * @author sheng
 * @date 2023-03-11
 * */
public interface IHandler {
    /**
     * 处理请求
     * */
    void handleRequest(Request req);
    /**
     * 设置下一个处理器
     * */
    void  setNext(IHandler next);
}
