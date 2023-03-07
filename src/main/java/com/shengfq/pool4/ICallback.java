package com.shengfq.pool4;

/**
 * 抽象回调方法
 */
public interface ICallback {

    /**
     * 回调方法
     * @param isSuccess true ： 执行成功结束，false：try catch到异常结束
     */
    String callback(boolean isSuccess);
}
