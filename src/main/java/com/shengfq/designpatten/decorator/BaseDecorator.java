package com.shengfq.designpatten.decorator;
/**
 * ClassName: ClientNotifier
 * Description:
 *需求场景,任意组合不同的通知方式,无需静态组合通知代码
 * @author shengfq
 * @date: 2022/12/18 2:59 下午
 */
public class BaseDecorator implements Notifier{
    //原有通知对象
    private Notifier wrapper;
    public BaseDecorator(Notifier wrapper){
        this.wrapper = wrapper;
    }
    //增强的方法
    public void before(IMessage message){
        System.out.println("前置增强:"+message.getMessage());
    }
    //增强的方法
    public void after(IMessage message){
        System.out.println("后置增强:"+message.getMessage());
    }

    /**
     * 发送消息
     *
     * @param message
     */
    @Override
    public void send(IMessage message) {
        //before(message);
        wrapper.send(message);
       // after(message);
    }
}
