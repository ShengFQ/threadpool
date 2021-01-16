package com.shengfq.memoryleak;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 内存泄漏:
 * 原因:
 * 1.过期引用没有释放
 * */
public class TestStack {
    private Object[] elements;

    private int size=0;

    private static final int DEFAULT_INITIAL_CAPACITY=16;

    public TestStack(){
        elements=new Object[DEFAULT_INITIAL_CAPACITY];
    }
    /**
     * add element
     *
     * */
    public void push(Object o) {
        //扩容
        ensureCapacity();
        elements[size++]=o;
    }
    /**
     * delete element
     * 并没有将不需要的内存引用清空
     * */
    public Object pop(){
        if(size==0){
            throw new EmptyStackException();
        }
        return elements[--size];
    }
    /**
     * delete element
     * 手动释放内存空间
     * */
    public Object pop2(){
        if(size==0){
            throw new EmptyStackException();
        }
        Object o=elements[--size];
        elements[size]=null;
        return o;
    }

    /**
     * 确保容量足够
     * */
    private void ensureCapacity(){
        if(elements.length==size){
            elements= Arrays.copyOf(elements,2*size+1);
        }
    }

    public static void main(String[] args) {
        TestStack instance=new TestStack();
        int index=0;
        while(true){
            instance.push(index);
            index++;
           // if(index%2==0) {
                Object e = instance.pop();
           // }
            System.out.println(String.format("array length: %s array size: %s ",instance.elements.length,instance.size));
        }
    }
}
