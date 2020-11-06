package com.shengfq.lock;

public class TestClassLock {
	//每个Object类都有wait,notify
	static Class  myClass=TestClassLock.class;
	Class objectClass;
	public TestClassLock() {
		objectClass=this.getClass();
		System.out.println("objectClass code:"+objectClass.hashCode());
		System.out.println("staticClass code"+myClass.hashCode());
	}
	
	public static void main(String[] args) {
		TestClassLock classLockA=new TestClassLock();
		TestClassLock classLockB=new TestClassLock();
		System.out.println(classLockA.myClass==classLockB.myClass);//静态字段属于类 为所有对象共享
		System.out.println(classLockA.objectClass==classLockB.objectClass);//每个对象区域字段,但是一个类的所有对象共用一个Class对象
		//pre true,true
	}
}
