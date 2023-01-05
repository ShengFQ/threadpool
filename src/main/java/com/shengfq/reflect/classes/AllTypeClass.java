package com.shengfq.reflect.classes;

import com.shengfq.reflect.Animal;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * ClassName: AllTypeClass
 * Description: 演示那些类型有Class对象
 *
 * @author shengfq
 * @date: 2023/1/5 10:46 上午
 */
public class AllTypeClass {
    /**
     * 哪些类有class对象
     */
    private static void getTypeClass() {
        Class<String> cls1 = String.class;//外部类
        Class<Serializable> cls2 = Serializable.class;//接口
        Class<Integer[]> cls3 = Integer[].class;//数组
        Class<float[][]> cls4 = float[][].class;//二维数组
        Class<Deprecated> cls5 = Deprecated.class;//注释
        Class<Thread.State> cls6 = Thread.State.class;//枚举
        Class<Long> cls7 = long.class;//基本数据类型
        Class<Void> cls8 = void.class;//void数据类型
        Class<Class> cls9 = Class.class;
        System.out.println(cls1);
        System.out.println(cls2);
        System.out.println(cls3);
        System.out.println(cls4);
        System.out.println(cls5);
        System.out.println(cls6);
        System.out.println(cls7);
        System.out.println(cls8);
        System.out.println(cls9);
    }

    /**
     * class对象的属性和方法
     * Method 和 Field、Constructor 对象都有 setAccessible()方法
     */
    private static void getClassDefinition() {
        try {
            Class animalClass = Class.forName("com.shengfq.reflect.Animal");
            Animal animal = (Animal)animalClass.newInstance();
            //class的属性列表
            Field[] fields = animalClass.getDeclaredFields();
            for (Field field : fields) {
                //class的属性定义 访问修饰符/类型/名字
                field.setAccessible(true);
                String name = field.getName();
                int modifiers = field.getModifiers();
                Class fieldTypes = field.getType();
                field.set(animal,1);
                Object fieldValue=field.get(animal);
                System.out.printf("field:%s  value:%s",name,fieldValue);
                System.out.println("");
            }
            //class的属性反射赋值

            //class的方法列表
            Method[] methods = animalClass.getDeclaredMethods();
            //class的方法定义 访问修饰符/返回类型/形参类型/形参名字
            for (Method method : methods) {
                method.setAccessible(true);
                String name=method.getName();
                Object returnValue= method.invoke(animal);
                System.out.printf("method:%s  returnValue:%s",name,returnValue);
                System.out.println("");
            }
            //class的方法,反射调用.

            //class的构造器
            Constructor[] constructors = animalClass.getDeclaredConstructors();

            //class创建对象实例


        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (java.lang.reflect.InvocationTargetException e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        getClassDefinition();
    }

}
