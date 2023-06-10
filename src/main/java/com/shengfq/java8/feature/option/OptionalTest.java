package com.shengfq.java8.feature.option;

import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * ClassName: OptionalTest
 * Description: 防御式编程
 *引入Optional
 * 类的意图并非要消除每一个null引用。与此相反，它的目标是帮助你更好地设计出普适的API
 * @author shengfq
 * @date: 2023/6/10 8:03 下午
 */
public class OptionalTest {
    public static void main(String[] args) {
        //Person person=new Person(new Car(new Insurance("insurance")));
       // String out=person.getCar().getInsurance().getName();
       // System.out.println(out);
       // Person person1=new Person();
        //NPE
        //out=person1.getCar().getInsurance().getName();
        //System.out.println(out);
        //NPE
       // Optional.ofNullable(person1.getCar().getInsurance()).ifPresent(System.out::println);
        Person person1=new Person();
        Optional<Person> optPerson=Optional.of(person1);
        String name =
                optPerson.flatMap(Person::getCar)
                        .flatMap(Car::getInsurance)
                        .map(Insurance::getName)
                        .orElse("unknown");
        System.out.println("name:"+name);
    }
}
@NoArgsConstructor
@AllArgsConstructor
class Person{
   // private Car car;
   // public Car getCar() { return car; }
    //语义 有可能没有这个car变量
   private Optional<Car> car;
    public Optional<Car> getCar() { return car; }
}
@AllArgsConstructor
class Car{
   // private Insurance insurance;
   // public Insurance getInsurance() { return insurance; }
   private Optional<Insurance> insurance;
    public Optional<Insurance> getInsurance() { return insurance; }
}
@AllArgsConstructor
class Insurance{
    private String name;
    public String getName() { return name; }

}
