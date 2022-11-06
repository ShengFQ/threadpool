package com.shengfq.reflect;

/**
 * 介绍获取Class对象的六种方式
 * @author sheng
 */
public class GetClassObject {
   public static final String CLASS_NAME="com.shengfq.reflect.Animal";
   public static void main(String[] args) throws ClassNotFoundException {
      //1、Class.forName(完整类名),一般用于从外部文件中读取完整类名，然后据此创建对象
      Class cls1 = Class.forName(CLASS_NAME); //这个类名一般是从外部文件获取的，我们这里直接给出了
      System.out.println("1、cls1 = " + cls1);

      //2、类名.class ， 一般用于参数传递
      Class cls2 = Integer.class;
      System.out.println("2、cls2 = " + cls2);

      //3、类实例对象.getClass() ,一般用于已知某个类的实例，通过此实例来获取它关联的Class对象
      Animal wolf = new Animal();
      Class cls3 = wolf.getClass();
      System.out.println("3、cls3 = " + cls3);
      System.out.println("3、cls1 == cls3 ? " + (cls1 == cls3)); //一个类只有一个唯一的Class对象，所以是true

      //4、通过类加载器ClassLoader[4种]获取Class对象，
      //(1) 获取类加载器
      ClassLoader classLoader = wolf.getClass().getClassLoader();
      //(2) 通过类加载器的loadClass()方法得到Class对象
      Class cls4 = classLoader.loadClass(CLASS_NAME);//传入完整类名做参数
      System.out.println("4、cls4 = " + cls4);

      //5、基本数据类型可以按： 基本数据类型.class 得到Class对象 (byte、short、int、long、char、float、double、boolean)
      Class cls5 = int.class;
      //实际底层会把基本数据类型装箱成包装类型，即这样
      Class<Character> characterClass = char.class;
      System.out.println("5、cls5 = " + cls5);

      //6、基本数据类型的包装类型可以通过.TYPE 得到Class对象
      Class<Integer> cls6 = Integer.TYPE;
      System.out.println("6、cls6 = " + cls6);

   }
}
