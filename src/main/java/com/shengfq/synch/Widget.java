package com.shengfq.synch;

/**
 * ClassName: Widget
 * Description: TODO
 *
 * @author shengfq
 * @date: 2025/4/3 22:25
 */
public class Widget {

    public  synchronized void doSomething(){
        System.out.println("this is Widget doSomething");
    }
}
