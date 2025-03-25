package com.shengfq.designpatten.sfactory;

/**
 * 简单工厂模型
 * 目的:将对象的创建和对象的使用进行解耦
 * 角色: 工厂类/抽象产品/具体产品
 * 优点:简单
 * 缺点:具体产品的实例化是依赖ifelse逻辑实现,不利于扩展,适应于简单已知产品类型不会扩展的场景.
 */
public class KeyboardFactory {

    public Keyboard getInstance(int brand) {
        if(1 == brand){
            return new HPKeyboard();
        } else if(2 == brand){
            return new LenovoKeyboard();
        } else if(3 == brand){
            return new DellKeyboard();
        }
        return null;
    }

    public static void main(String[] args) {
        KeyboardFactory keyboardFactory = new KeyboardFactory();
        Keyboard keyboard = keyboardFactory.getInstance(1);
        keyboard.print();
        keyboard = keyboardFactory.getInstance(2);
        keyboard.print();
        keyboard = keyboardFactory.getInstance(3);
        keyboard.print();
    }

}
