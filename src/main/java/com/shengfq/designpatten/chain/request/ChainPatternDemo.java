package com.shengfq.designpatten.chain.request;
/**
 * 责任链模式
 * 1.责任链抽象类:包含下个处理器引用,建立链接
 * 2.请求类
 * 3.业务逻辑处理实现类
 * */
public class ChainPatternDemo {
    private static AbstractHandler getChainOfHandler() {
        return new AbstractHandler.Builder()
                .addHandler(new Handler1())
                .addHandler(new Handler2())
                .addHandler(new Handler3())
                .build();
    }

    public static void main(String[] args) {
        AbstractHandler chain = getChainOfHandler();
        LeaveRequest request1 = new LeaveRequest("张三", 2);
        chain.linkChain(request1);

        LeaveRequest request2 = new LeaveRequest("李四", 5);
        chain.linkChain(request2);

        LeaveRequest request3 = new LeaveRequest("王五", 10);
        chain.linkChain(request3);
    }
}
