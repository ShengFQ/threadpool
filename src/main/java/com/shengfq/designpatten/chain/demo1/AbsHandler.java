package com.shengfq.designpatten.chain.demo1;

import lombok.Data;

/**
 * ClassName: AbsHandler
 * Description: 抽象的链节点类
 *
 * @author shengfq
 * @date: 2024/2/3 11:31 上午
 */
@Data
public abstract class AbsHandler {
    private AbsHandler nextHandler;

    /**
     * 处理方法抽象
     * */
    public abstract void handle(Request request);
    /**
     * 构建链
     * */
    public void  buildChain(Request request){
        handle(request);
        if(nextHandler!=null){
            nextHandler.handle(request);
        }
    }

    public static class Builder {
        private AbsHandler head;
        private AbsHandler tail;

        public Builder addHandler(AbsHandler handler) {
            if (this.head == null) {
                this.head = this.tail = handler;
                return this;
            }
            this.tail.setNextHandler(handler);
            this.tail = handler;
            return this;
        }

        public AbsHandler build() {
            return this.head;
        }
    }
}
