package com.shengfq.designpatten.decorator;

/**
 * ClassName: SMSDecorator
 * Description: QQ 通知装饰器
 *
 * @author shengfq
 * @date: 2022/12/18 3:56 下午
 */
public class QQDecorator extends BaseDecorator implements Notifier{
    public QQDecorator(Notifier notifier){
        super(notifier);
    }

    @Override
    public void send(IMessage message) {
        super.send(message);
        sendQQMessage(message);
    }

    public void sendQQMessage(IMessage message){
        System.out.println("QQ装饰器增强");
    }
}
