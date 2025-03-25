package com.shengfq.designpatten.sfactory;

class LenovoKeyboard implements Keyboard {

    @Override
    public void print() {
        //...输出逻辑;
        System.out.println("lenovo print ");
    }

    @Override
    public void input(String context) {
        //...输入逻辑;
        System.out.println("lenovo input "+context);
    }

}
