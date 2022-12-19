package com.shengfq.designpatten.decorator;

/**
 * ClassName: SMSNotifier
 * Description: 短信通知
 *
 * @author shengfq
 * @date: 2022/12/18 3:03 下午
 */
public class SMSNotifier extends AbsNotifier{
    /**
     * 发送消息
     *
     * @param message
     */
    @Override
    public void sendExt(IMessage message) {
        System.out.println("发送SMS消息:"+message.getMessage());
    }
}
