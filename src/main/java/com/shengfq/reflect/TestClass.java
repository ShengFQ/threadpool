package com.shengfq.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class类的学习
 * @author shengfq
 * @date 2022-06-26
 * */
public class TestClass {

    public static void classObjectOne(){
        TestClass run=new TestClass();
       Class<Fruits> fruitsClass1=(Class<Fruits>) run.getClassObject1();
        Class<Fruits> fruitsClass2=(Class<Fruits>) run.getClassObject2();
        Class<Fruits> fruitsClass3=(Class<Fruits>) run.getClassObject3();
        if(fruitsClass3==fruitsClass1 && fruitsClass2==fruitsClass3 && fruitsClass2==fruitsClass1){
            System.out.println("class object is only one");
        }else{
            System.out.println("they are not equal");
        }
       /*Method[] methods=fruitsClass.getMethods();
       for (Method method :methods){
           String methodName=method.getName();
           System.out.println("method:"+methodName);
       }*/
    }
    /**
     * class对象的获取方法
     * */
    public Class<Fruits> getClassObject1(){
        try {
            return (Class<Fruits>)Class.forName("com.shengfq.reflect.Fruits");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Class<? extends Fruits> getClassObject2(){
        Fruits fruits=new Fruits();
        return fruits.getClass();
    }

    public Class<Fruits> getClassObject3(){
        return Fruits.class;
    }


    /**
     * 获取构造函数
     * 有 Declared 的方法，都表示只能获取本类的属性(不包括父类的)
     * 可以获取所有修饰符修饰的属性(公有，保护，默认，私有).
     * 不带有 Declared 的方法，可以获取本类及父类的所有的属性，不过只能获取 公有 修饰符的 。
     * */
    public void getConstructor(Class<Fruits> fruitsClass){
        Constructor<?>[] constructors1=fruitsClass.getDeclaredConstructors();
        for (Constructor constructor:constructors1){
            String name=constructor.getName();
            System.out.println("constructor:"+name);
        }
    }

    /**
     * 获取成员变量
     * 返回指定的 Field 对象
     * Field getField(String name)
     * Field getDeclaredField(String name)
     * */
    public void getFields(Class<Fruits> fruitsClass){
        Field[] fields=fruitsClass.getDeclaredFields();
        for (Field field:fields){
            String name=field.getName();
            System.out.println("field:"+name);
        }
    }
    /**
     * 获取成员方法
     * */
    public void getMethods(Class<Fruits> fruitsClass){
        Method[] methods=fruitsClass.getDeclaredMethods();
        Arrays.stream(methods).forEach(System.out::println);
    }
    /**
     * 获取注解方法
     * */
    public void getAnnotationMethods(Class<Fruits> fruitsClass){
        Annotation[] annotations=fruitsClass.getDeclaredAnnotations();
        Arrays.stream(annotations).forEach(System.out::println);
    }
    /**
     * class对象也能通过newInstance()方法构造一个实例对象.
     * */
    public void createClass(Class<Fruits> fruitsClass){
        try {
            Fruits instance=fruitsClass.newInstance();
            instance.setPrice(1);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    /**
     * 返回底层类的规范化名称
     * */
    public void getCanon(Class<Fruits> fruitsClass){
        String a= fruitsClass.getCanonicalName();
        System.out.println(a );
    }

    /**
     * 返回全限定名(全限定名：包名.类名)
     * */
    public void getClassName(Class<Fruits> fruitsClass){
        String name=fruitsClass.getName();
        System.out.println("name:"+name);
    }
    /**
     * 返回全限定名(全限定名：包名.类名)
     * */
    public void isLocalClass(Class<Fruits> fruitsClass){
        // 判断是不是局部类，也就是方法里面的类
        boolean islocal=fruitsClass.isLocalClass();
        System.out.println("is local:"+islocal);
    }

    private void printClass() throws Exception{
        Class clazz = Cat.class;
        System.out.println("获取本类所有 public 构造方法");
        for (Constructor constructor : clazz.getConstructors()) {
            System.out.println(constructor.toString());
        }
        System.out.println();
        System.out.println("获取本类所有构造方法");
        for (Constructor declaredConstructor : clazz.getDeclaredConstructors()) {
            System.out.println(declaredConstructor.toString());
        }
        System.out.println();
        System.out.println("这里获取指定的带有两个参数的私有构造方法");
        Constructor privateConstructor = clazz.getDeclaredConstructor(int.class, int.class);
        System.out.println(privateConstructor.toString());
        //  改变访问权限
        privateConstructor.setAccessible(true);
        Cat cat = (Cat) privateConstructor.newInstance(1, 2);
        System.out.println(cat.toString());

        System.out.println();
        System.out.println("这里获取指定的带有一个参数的公有构造方法");
        Constructor publicConstructor = clazz.getConstructor(int.class);
        System.out.println(publicConstructor.toString());
        Cat cat2 = (Cat) publicConstructor.newInstance(100);
        System.out.println(cat2.toString());
    }


    public static void main(String[] args) throws Exception {
        reflectList();
        System.out.println("-------------");

    }
    /**
     * 通过Class的反射API,可以绕过泛型的类型检测,达到往泛型集合添加不同类型元素的目的.
     * */
    private static void reflectList() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<String> list2 = new ArrayList<String>();
        list2.add("a");
        Class<?> c = list2.getClass();
        Method method = c.getDeclaredMethod("add",Object.class);
        method.invoke(list2,20);
        System.out.println(list2.size());
    }

}
