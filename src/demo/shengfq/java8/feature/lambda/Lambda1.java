package demo.shengfq.java8.feature.lambda;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * lambda表达式第一课
 * @author sheng
 * @date 2020-06-05
 * component:
 * 参数列表
 * 箭头
 * 主体
 * */
public class Lambda1 {
    public static void main(String[] args) {
        method5();
    }
    /**
     * 风格1 表达式
     * (parameters) -> expression
     * */
    private static void method1(){
        Person p1=new Person(1,"a");
        Person p2=new Person(2,"b");

    }
    /**
     * 风格2 块风格
     * (parameters) -> { statements; }
     * */
    private static   void method2(){
        Person p1=new Person(1,"a");
        Person p2=new Person(2,"b");

    }

    /**
     * java自带的
     * */
    private static void method3(){
        Predicate<Person> oldPredicate=a ->a.getAge()>150;
        oldPredicate.test(new Person(100,"job"));
    }

    /**
     * 方法引用
     * 仅当在Lambda表达式中直接调用了一个方法时可以使用。其写法为目标引用::方法名称。
     * */
    private static void method4(){
        Function<Person, Integer> weightor = a -> a.getAge();
        weightor.apply(new Person(1,"jim"));

        Function<Person, Integer> weightor1 = Person::getAge;
        weightor1.apply(new Person(1,"jim"));
    }

    /**
     * 复合表达式
     * 比较器复合（Comparator）
     * */
    private static void method5(){
        List<Apple> apples = Arrays.asList(new Apple("red", 50),
                new Apple("red", 150),
                new Apple("green", 100));
        apples.sort(Comparator.comparing(Apple::getWeight));//重量从小到大排列
        //遍历集合对象
        apples.stream().forEach(apple -> {
            System.out.println(apple.toString());
        });
        System.out.println("=======================");
        apples.sort(Comparator.comparing(Apple::getWeight).reversed());//重量从大到小
        //遍历集合对象
        apples.stream().forEach(apple -> {
            System.out.println(apple.toString());
        });
        //复杂排序 按重量从大大小后再按名称排序
        apples.sort(Comparator.comparing(Apple::getWeight)
                .reversed().thenComparing(Apple::getType));
        //遍历list中某个元素
        apples.stream().filter(Objects:: nonNull).filter(id->id!=null).forEach(id->{
            System.out.println(id);
        });
    }

    /**
     * 遍历map
     * */
    private static void method6(){
        Map<String, String> map = new HashMap<String, String>() {{
            put("a", "haha");
            put("b", "hahaha");
            put("d", "hahe");
            put("c", "haheeee");
        }};

        map.forEach((k, v) -> {
            System.out.print("key=" + k);
            System.out.print("\t");
            System.out.println("value=" + v);
        });
    }

    /**
     * 可以在 Lambda 表达式中引用的变量必须是声明为 final
     * 或是实际上 final（effectively final）的
     * */
    private static void method7(){
        String name="alex";
        new Thread(()-> System.out.println("hello"+name)).start();
    }
}
