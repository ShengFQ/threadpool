package com.shengfq.lang;
/**
 * 普通类型与引用类型的专题
 * 1.比较
 * 2.转换
 * 3.赋值
 * */
public class GeneralClass {
	public static void main(String[] args) {
		//对于基本数据类型来说，赋值（=号）就相当于拷贝了一份值
		//数组是引用类型,对象变量存放的是内存空间的地址,当执行到new这个关键字，会在堆内存分配内存空间，并把该内存空间的地址赋值给arr1。
		//对于引用类型来说，赋值（=号）就相当于拷贝了一份内存地址
		Integer a=new Integer(1);
		Integer b=new Integer(1);
		int c=1;
		System.out.println("a==b ?"+(a==b));//expect false actual false
		System.out.println("a==c ?"+(a==c));//expect false actual true
		System.out.println("a.value==c ?"+(Integer.valueOf(a)==c));//expect true actual true
	}
}
