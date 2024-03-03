package com.shengfq.generic;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: GenericClass
 * Description: 泛型类
 *
 * @author shengfq
 * @date: 2022/12/28 4:44 下午
 */
@Data
public class GenericClass<T extends Serializable> {
    private List<T> contain=new ArrayList<>(15);

    private T t;
    private int code;
    private String message;
    /**
     * 添加元素
     * */
    public T add(T t){
        if(!contain.contains(t)){
            contain.add(t);
        }
        return t;
    }
    /**
     * 删除元素
     * */
    public void pop(T t){
        if(contain.contains(t)){
           contain.remove(t);
        }
    }
    /**
     * 循环元素
     * */
    public void loop(){
        for(T t:contain){
            System.out.println("element:"+t);
        }
    }
    public List<T> getContain(){
        return contain;
    }


    public static void main(String[] args) {
      //  serialize();
      //  serialize4();

        deserialize1();
        deserialize2();
    }
    //序列化基本类型
    public static void serialize(){
        GenericClass<String> cls2=new GenericClass<>();
        cls2.add("sheng");
        cls2.add("he");
        cls2.add("zu");
       String json= JSON.toJSONString(cls2.getContain());
        System.out.println("string类型的 json序列化:"+json);
    }

    //序列化对象类型
    public static void serialize4(){
    GenericClass<Student> cls=new GenericClass<>();
        cls.add(new Student("sheng",34));
        cls.add(new Student("he",29));
        cls.add(new Student("mother",60));
        String json= JSON.toJSONString(cls);
        System.out.println("对象类型的 json序列化:"+json);
    }
    //反序列化基本类型
    public static void deserialize1(){
        String json="[\"sheng\",\"he\",\"zu\"]";
       List<String> arrays= JSONObject.parseArray(json,String.class);
        arrays.stream().forEach(System.out::println);
    }
    /**
     * 反序列化泛型类型
     * com.alibaba.fastjson.JSONObject cannot be cast to com.shengfq.generic.Student
     * 因为无法预判contain数组内的元素类型,而用户自以为泛型对象为Student,导致编译没问题,但是运行时报异常
     * */
    public static void deserialize2(){
        String json="{\"code\":0,\"contain\":[{\"age\":34,\"name\":\"sheng\"},{\"age\":29,\"name\":\"he\"},{\"age\":60,\"name\":\"mother\"}]}";
       /* GenericClass<Student> students=JSONObject.parseObject(json,GenericClass.class);
       List<Student> studentList= students.getContain();
        studentList.stream().forEach(System.out::println);*/

        GenericClass<Student> students=JSONObject.parseObject(json,new TypeReference<GenericClass<Student>>(){});
        List<Student> studentList= students.getContain();
        studentList.stream().forEach(System.out::println);
    }
}
