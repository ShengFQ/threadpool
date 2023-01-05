package com.shengfq.reflect.classes;

import com.shengfq.reflect.Animal;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author LeeZhi
 * @version 1.0
 * 反射问题的引入
 */
@SuppressWarnings({"all"})
public class ReflectionQuestion {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        //根据配置文件re.properties指定信息，创建Cat对象并调用方法hi
        //回忆

        //传统的方式  new 对象 -> 调用方法
        //Cat cat = new Cat();
        //cat.hi();====>cat.cry()  修改源码

        //我们尝试用io做一下 -> 明白反射

        //1.使用properties类,可以读写配置文件
        Properties properties = new Properties();
        properties.load(new ClassPathResource("app-config.properties").getInputStream());
        String classfullpath = properties.getProperty("classfullpath").toString();//"com.hspedu.Cat"
        String method = properties.get("method").toString();//"hi"
        System.out.println("classfullpath:" + classfullpath +"\n"+ "method:" + method);

        //2.创建对象,传统的方法,行不通  => 反射机制
        //Cat cat2 = new com.gbx.Cat();//new classfullpath()  -> String

        //3.使用反射机制解决
        //(1),返回Class类型的对象
        Class cls = Class.forName(classfullpath);
        //(2)通过 cls 得到你加载的类com.gbx.Cat() 的对象的实例
        Animal o = (Animal)cls.newInstance();
        //(3) 通过cls得到修加载的类com.gbx.Cat 的 methodName"hi" 的方法对象
        //    即：在反射中，可以把方法视为对象（万物皆对象）
        Method method1 = cls.getMethod(method);
        //(4) 通过method1 调用方法:即通过方法对象来实现调用方法
        System.out.println("===================================");
        method1.invoke(o);//传统方法 对象.方法 , 反射机制  方法.invoke(对象)
    }
}
