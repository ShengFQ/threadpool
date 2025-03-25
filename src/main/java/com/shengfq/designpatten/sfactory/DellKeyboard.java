package com.shengfq.designpatten.sfactory;

class DellKeyboard implements Keyboard {

    @Override
    public void print() {
        //...输出逻辑;
        System.out.println("dell keyboard print");
    }

    @Override
    public void input(String context) {
        //...输入逻辑;
        System.out.println("dell input "+context);
    }

}
