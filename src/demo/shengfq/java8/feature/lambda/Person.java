package demo.shengfq.java8.feature.lambda;

import java.util.Comparator;
/**
 * 自实现函数式接口
 *
 * */
public class Person implements Comparator<Person> {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(int age, String name){
        this.age=age;
        this.name=name;
    }

    /**
     * 下面用函数描述符来表示上述三个方法的签名，箭头前面是方法的入参类型，后面是返回类型。
     * compare：(T, T) -> int，两个泛型T类型的入参，返回int类型
     * */
    @Override
    public int compare(Person o1, Person o2) {
        if(o1==null || o2==null){
            return 0;
        }
        int age1=o1.age;
        int age2=o2.age;
        return age1-age2;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
