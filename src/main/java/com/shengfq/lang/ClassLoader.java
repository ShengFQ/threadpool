package com.shengfq.lang;

public class ClassLoader {
	private static String block="1";
	private static String sblock=block+"s";
	static{
		System.out.println("static block ");
		block="2";
	}
	public ClassLoader(){
		block="3";
	}
	private static void printBlock(){
		System.out.println(sblock);
	}
	public static void main(String[] args) {
		printBlock();
		//ClassLoader loader=new ClassLoader();
		System.out.println(ClassLoader.block);
	}
}
