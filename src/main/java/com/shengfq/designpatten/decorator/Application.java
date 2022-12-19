package com.shengfq.designpatten.decorator;

/**
 * 装饰者模式、装饰器模式、Wrapper、Decorator
 * ClassName: Application
 * 使用场景:
 * 如果你希望在无需修改代码的情况下即可使用对象， 且希望在运行时为对象新增额外的行为， 可以使用装饰模式。
 *  装饰能将业务逻辑组织为层次结构， 你可为各层创建一个装饰， 在运行时将各种不同逻辑组合成对象。 由于这些对象都遵循通用接口， 客户端代码能以相同的方式使用这些对象。
 *
 *  如果用继承来扩展对象行为的方案难以实现或者根本不可行， 你可以使用该模式。
 *  许多编程语言使用 final最终关键字来限制对某个类的进一步扩展。 复用最终类已有行为的唯一方法是使用装饰模式： 用封装器对其进行封装。
 * @author shengfq
 * @date: 2022/12/18 3:46 下午
 * 装饰可让你更改对象的外表， 策略模式则让你能够改变其本质。
 */
public class Application {
    public static void main(String[] args) {
        IMessage message=new Message();
        //不同的实现
        System.out.println("------单向增强---------");
        Notifier qqNotifier=new QQNotifier();
        Notifier smsNotifier=new SMSNotifier();
        //单向增强
        qqNotifier=new QQDecorator(qqNotifier);
        smsNotifier=new SMSDecorator(smsNotifier);
        qqNotifier.send(message);
        smsNotifier.send(message);
        System.out.println("--------------");
        //组合增强
        smsNotifier=new SMSDecorator(smsNotifier);
        smsNotifier=new QQDecorator(smsNotifier);
        smsNotifier.send(message);
    }
}
