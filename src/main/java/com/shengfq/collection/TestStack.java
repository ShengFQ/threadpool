package com.shengfq.collection;

import java.util.*;

/**
 * Created by sheng on 18/9/10.
 */
public class TestStack {
    private Stack<Student> students=new Stack<Student>();
    private Set<Student> studentSet=new TreeSet<Student>();
    //通过一个学生
    private Hashtable<Student,School> school=new Hashtable<Student,School>();
    private void add(Student student){
        students.add(student);
    }

    private void push(Student student){
        students.push(student);
    }

    private void remove(Student student){
        students.remove(student);
    }

    private void pop(){
        students.pop();
    }

    private Student get(int index){
       return students.get(index);
    }

    private Student peek(){
        return students.peek();
    }

    private School searchStudent(Student student){
        return school.get(student);
    }

}
class School{
    private int classRoom;
    private int studentSum;
}
class Student extends Object{
    private int id;
    private String name;
    private String studentNo;
    //可变字段不用于计算hashcode
    private int age;

    @Override
    public int hashCode() {
       return Objects.hash(id,name,studentNo);
    }

    @Override
    public boolean equals(Object anObject) {
       //return Objects.equals(this,anObject);
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof Student) {
            Student anotherStudent = (Student)anObject;
            return id==anotherStudent.id && name.equals(anotherStudent.name) && studentNo.equals(anotherStudent.studentNo);
        }
        return false;
    }

}
