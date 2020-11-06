package com.shengfq.memoryleak;

import com.shengfq.model.Person;

import java.util.HashSet;
import java.util.Set;

public class TestSet {
    public static void main(String[] args)
    {
        Set<Person> set = new HashSet<Person>();
        Person p1 = new Person("唐僧","pwd1",25);
        Person p2 = new Person("孙悟空","pwd2",26);
        Person p3 = new Person("猪八戒","pwd3",27);
        set.add(p1);
        set.add(p2);
        set.add(p3);
        System.out.println("总共有:"+set.size()+" 个元素!");
        p3.setAge(2);
        set.remove(p3);
        set.add(p3);
        System.out.println("总共有:"+set.size()+" 个元素!");
        for (Person person : set)
        {
            System.out.println(person);
        }
    }
}
