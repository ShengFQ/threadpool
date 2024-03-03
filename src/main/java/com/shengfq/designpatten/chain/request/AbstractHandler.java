package com.shengfq.designpatten.chain.request;

import java.util.Objects;

/**
 * <p>
 * 责任链模式——抽象类处理器
 * </p>
 */

public abstract class AbstractHandler {

    /**
     * 责任链中的下一个元素
     */
    protected AbstractHandler nextHandler;

    private void setNextChain(AbstractHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    /**
     * 责任链处理逻辑
     */
    public void linkChain(LeaveRequest request) {
        handler(request);
        //这里还可以加入其他方法
        if (Objects.nonNull(nextHandler)) {
            nextHandler.linkChain(request);
        }
    }

    /**
     * 抽象方法
     */
    protected abstract void handler(LeaveRequest request);

    public static class Builder {
        private AbstractHandler head;
        private AbstractHandler tail;

        public Builder addHandler(AbstractHandler handler) {
            if (this.head == null) {
                this.head = this.tail = handler;
                return this;
            }
            this.tail.setNextChain(handler);
            this.tail = handler;
            return this;
        }

        public AbstractHandler build() {
            return this.head;
        }
    }
}
