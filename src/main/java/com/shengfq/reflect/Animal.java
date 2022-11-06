package com.shengfq.reflect;

public class Animal {
    private int mAnimalPrivate;
    protected int mAnimalProtected;
    public int mAnimalpublic;

    public Animal() {
    }

    public Animal(int mAnimalPrivate) {
        this.mAnimalPrivate = mAnimalPrivate;
    }

    public Animal(int mAnimalPrivate, int mAnimalProtected) {
        this.mAnimalPrivate = mAnimalPrivate;
        this.mAnimalProtected = mAnimalProtected;
    }

    public Animal(int mAnimalPrivate, int mAnimalProtected, int mAnimalpublic) {
        this.mAnimalPrivate = mAnimalPrivate;
        this.mAnimalProtected = mAnimalProtected;
        this.mAnimalpublic = mAnimalpublic;
    }

    public void animalPublic() {
        System.out.println("Method : animalPublic");
    }

    private void animalPrivate() {
        System.out.println("Method : animalPrivate");
    }

    protected void animalProtected() {
        System.out.println("Method : animalProtected");
    }

}
