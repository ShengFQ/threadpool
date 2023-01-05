package com.shengfq.reflect;
/**
 * Class对象的获取方式
 * */
public class Apple extends Fruits{
    public static final String CLASS_NAME="com.shengfq.reflect.Animal";
    private static int a = 10;
    {
        System.out.println("普通代码块");
    }
    static{
        System.out.println("静态变量a:"+a);
        System.out.println("静态代码块");
    }

    public static void main(String[] args) {
        //注意，我在com.fdd.reflect包下建的类
        String user = CLASS_NAME;
        test(user);
    }
    public static void test(String user) {
        try {
            System.out.println("--------------class对象获取---------");
            ClassLoader loader = ClassLoader.getSystemClassLoader();
            Class<?> class1 = loader.loadClass(user);
            System.out.println("class Name: " + class1.getName());
            System.out.println("----------------另外一种Class对象获取-----------------------");
            Class class2 = Class.forName(user);
            System.out.println("class Name:  " + class2.getName());
            System.out.println("----------------另外一种Class对象获取-----------------------");
            Class class3=com.shengfq.reflect.Animal.class;
            System.out.println("class Name:  " + class3.getName());
            if(class1==class2) {
                System.out.println("class1==class2");
            }
            Animal animal1=new com.shengfq.reflect.Animal();
            Class class4=animal1.getClass();
            Animal animal2=new com.shengfq.reflect.Animal();
            Class class5=animal2.getClass();
            if(class4==class5){
                System.out.println("class4==class5");
            }
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
