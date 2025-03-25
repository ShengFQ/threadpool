package com.shengfq.designpatten.sfactory;

class HPKeyboard implements Keyboard {

    @Override
    public void print() {
        //...输出逻辑;
        System.out.println("hp keyboard print");
    }

    @Override
    public void input(String context) {
        //...输入逻辑;
        System.out.println("hp keyboard input "+context);
    }

}
