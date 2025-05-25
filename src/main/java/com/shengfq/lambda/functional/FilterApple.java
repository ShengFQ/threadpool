package com.shengfq.lambda.functional;

import com.shengfq.wujun.App;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 行为参数化案例
 * 行为也可以参数化是通过将可以变化的行为抽象成接口,
 * 将接口作为参数传递,在运行时根据传递不同的实现类对象来达到传递不同行为的目的.
 * */
public class FilterApple {

    public static void main(String[] args) {
        testFunctional();
    }

    /**
     * 2.函数式接口的附加操作,可以理解为管道式操作,设计模式:责任链
     * */
    public static void testFunctional(){
        int param1=1;
        //下面的语句就是一个只有一行代码的函数式接口 f1就是接口对象,理解为一个方法指针
        Function<Integer,Integer> f1=x->x+1;
        //f2也是一个方法指针
        Function<Integer,Integer> f2=x->x*2;

        // 先执行f1然后将结果放入f2
        Function<Integer,Integer> f3= f1.andThen(f2);
        Integer result= f3.apply(param1);
        System.out.println("数ᆜ上会写作f2(f1(x)) f1.andThen(f2):"+result);
        //先执行f2然后再执行f1
        Function<Integer,Integer> f4=f1.compose(f2);
        result=f4.apply(param1);
        System.out.println("数ᆜ上会写作f1(f2(x)) f1.compose(f2):"+result);
    }
    /**
     * 1.自定义函数式接口
     * */
    public static void testFunctionalDef(){
        Apple apple1=new Apple("green",120);
        Apple apple2=new Apple("red",160);
        Apple apple3=new Apple("green",160);
        Apple apple4=new Apple("red",110);
        List<Apple> list=new ArrayList<>();
        list.add(apple1);list.add(apple2);list.add(apple3);list.add(apple4);
        //调用foreach
        System.out.println("调用foreach 打印元素的列表:");
        forEach(list,(item)->System.out.println(item));
        System.out.println("------------");

        System.out.println("调用map 修改每个元素的重量并返回:");
        List<Apple> items=map(list,(s)-> {
            s.setWeight(s.getWeight()*2);
            return s;
        });
        items.forEach(System.out::println);
        System.out.println("------------");

        //行为封装到抽象的接口算法里,实例化不同对象代表使用不同的算法
        Predicate p1=new AppleColorPredicate();
        Predicate p2=new AppleRedAndHeavyPredicate();

        FilterApple test=new FilterApple();
        List<Apple> result1=  test.filter(list,p1);
        List<Apple> result2=  test.filter(list,p2);
        System.out.println("filter1 list:");
        result1.stream().map(Apple::toString).forEach(System.out::println);
        System.out.println("filter2 list:");
        result2.stream().map(Apple::toString).forEach(System.out::println);
        //使用函数式接口的lambda表达式,直接将行为传递给方法,减少了代码量
        List<Apple> result3=test.filter(list,item-> "red".equals(item.getColor()) && item.getWeight()<120);
        System.out.println("filter3 list:");
        result3.stream().map(Apple::toString).forEach(System.out::println);
    }
    /**
     * 参数化行为的调用,将算法调用封装到抽象接口里,运行时才知道调用的是哪个算法
     * */
    public static <T> List<T> filter(List<T> apples, Predicate<T> filter){
        List<T> result=new ArrayList<>();
        for (T apple:apples){
            if(filter.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }
    /**
     * 一些框架在设计抽象结构时,通过函数式接口留给调用者操作的自定义入口
     * 例如:框架在一些自定义事件处理时,留给调用者的处理钩子
     * */
    public static <T> void forEach(List<T> list, Consumer<T> consumer){
        for(T t:list){
            consumer.accept(t);
        }
    }
    /**
     * 对列表元素做修改并返回列表元素
     * */
    public static <T,R> List<R> map(List<T> list, Function<T,R> function){
        List<R> result=new ArrayList<>();
        for(T t:list){
           R r= function.apply(t);
           result.add(r);
        }
        return result;
    }


}
