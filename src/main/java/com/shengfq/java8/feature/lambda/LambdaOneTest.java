package com.shengfq.java8.feature.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import cn.hutool.core.util.RandomUtil;
import lombok.Data;

/**
 * ClassName: LambdaOneTest
 * Description: lambda表达式
 *
 * @author shengfq
 * @date: 2023/6/10 4:03 下午
 */
public class LambdaOneTest {
    private static List<Employee> employeeList=new ArrayList<>();
    private static void init(){
        for (int i = 0; i < 100; i++) {
            Employee employee=new Employee();
            employee.setName("name"+i);
            employee.setGender(i%2==0?'0':'1');
            employee.setAge(i);
            employee.setSalary(RandomUtil.randomInt(10,1000));
            employeeList.add(employee);
        }
    }

    public static void main(String[] args) {
        init();
        //通过stream选出性别为男的元素
        //filterGender(employeeList,'0');
        //通过Lambda的函数式编程接口匹配出性别为男的元素
       /* filterGender(employeeList,(x)->{
            return x.getGender()=='0';
        });*/
        sortSalary(employeeList);
        System.out.println("-----------");
        printFirst(employeeList);
    }
    /**
     * 函数式接口
     * 选出性别
     * */
    public static void filterGender(List<Employee> list, Predicate<Employee> p){
        for (Employee employee:list){
            if(p.test(employee)){
                System.out.println(employee);
            }
        }
    }

    /**
     * jdk stream自带的filter
     * */
    private static void filterGender(List<Employee> list,char gender){
        list.stream().filter(item->item.getGender()==gender).forEach(System.out::println);
    }
    /**
     * jdk stream 自带的排序
     * */
    public static void sortSalary(List<Employee> list){
        list.stream().sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::println);
    }

    public static void printFirst(List<Employee> list){
        list.stream().filter(item->item.getAge()>100).findFirst().ifPresent(System.out::println);
    }
}

@Data
class Employee{
    private String name;
    private int age;
    /**
     * 0-男性
     * 1-女性
     * */
    private char gender;
    private Integer salary;


}
