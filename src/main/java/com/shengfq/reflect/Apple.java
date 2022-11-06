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
            ClassLoader loader = ClassLoader.getSystemClassLoader();
            System.out.println("classloader testing...");
            Class<?> loaderUser = loader.loadClass(user);
            System.out.println("Animal " + loaderUser.getName());
            System.out.println("---------------------------------------");
            Class forNameUser = Class.forName(user);
            System.out.println("Class.forName testing...");
            System.out.println("Animal " + forNameUser.getName());
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
