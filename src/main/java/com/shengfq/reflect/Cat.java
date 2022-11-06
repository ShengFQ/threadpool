package com.shengfq.reflect;

public class Cat extends Animal {

    static {
        System.out.println("Loading Cat");
    }

    private int mCatPrivate;
    protected int mCatProtected;
    public int mCatpublic;


    public Cat() {
    }

    public Cat(int mCatPrivate) {
        this.mCatPrivate = mCatPrivate;
    }

    private Cat(int mCatPrivate, int mCatProtected) {
        this.mCatPrivate = mCatPrivate;
        this.mCatProtected = mCatProtected;
    }

    public void catPublic() {
        System.out.println("Method : catPublic");
    }

    private void catPrivate() {
        System.out.println("Method : catPrivate");
    }

    protected void catProtected() {
        System.out.println("Method : catProtected");
    }

    @Override
    public String toString() {
        return "mCatPrivate = " + mCatPrivate + "-----------" + "mCatProtected = " + mCatProtected + "-----------" + "mCatpublic = " + mCatpublic;
    }
}
