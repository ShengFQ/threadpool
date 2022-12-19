package com.shengfq.designpatten.decorator;

/**
 * ClassName: Message
 * Description: TODO
 *
 * @author shengfq
 * @date: 2022/12/18 3:46 下午
 */
public class Message implements IMessage{
    @Override
    public String getMessage() {
        return "通知内容";
    }
}
