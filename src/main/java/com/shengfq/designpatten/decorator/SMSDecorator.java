package com.shengfq.designpatten.decorator;

/**
 * ClassName: SMSDecorator
 * Description: SMS通知装饰器
 *
 * @author shengfq
 * @date: 2022/12/18 3:56 下午
 */
public class SMSDecorator extends BaseDecorator implements Notifier{
    public SMSDecorator(Notifier notifier){
        super(notifier);
    }

    @Override
    public void send(IMessage message) {
        super.send(message);
        SMSMessage(message);
    }

    public void SMSMessage(IMessage message){
        System.out.println("SMS装饰器增强");
    }
}
