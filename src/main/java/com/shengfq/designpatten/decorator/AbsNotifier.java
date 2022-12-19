package com.shengfq.designpatten.decorator;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: AbsNotifier
 * Description: 实现类
 * @author shengfq
 * @date: 2022/12/18 2:56 下午
 */
public abstract class AbsNotifier implements Notifier{
    private List<IMessage> messages=new ArrayList<>();
    /**
     * 发送消息
     * @param message
     */
    @Override
    public void send(IMessage message){
        System.out.println("默认的发送站内通知");
        //sendExt(message);
    }

    public abstract void sendExt(IMessage message) ;
}
