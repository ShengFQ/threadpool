package com.shengfq.memoryleak;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
public class TestObjectList {
	private static List<Area> areaList=new LinkedList<Area>();
	public static void main(String[] args) {
		addCollection();
		System.out.println("over");
	}
	
	private static void addCollection(){
		for(int i=0;i<10000;i++){
			Area area=new Area(i);
			areaList.add(area);
		}
		for(int i=0;i<5000;i++){
			Area area=areaList.get(i);
			area=null;
		}
		for(int i=0;i<10000;i++){			
			System.out.print("-"+areaList.get(i));
		}
	}
}

class Area implements Comparable{
	public Area(int a){
		this.a=a;
	}
	public int a=new Random().nextInt(1000)*100;
	@Override
	public int compareTo(Object o) {
		Area object=(Area)o;
		if( this.a==object.a)return 0;
		if( this.a>object.a)return 1;
		if( this.a<object.a)return -1;
		return 2;
	}
	public boolean equals(Object o) {
        if (this == o) return true;  //先判断o是否为本对象，如果是就肯定是同一对象了，this 指向当前的对象
        if (o == null || getClass() != o.getClass()) return false; //再判断o是否为null，和o.类对象和本类对象是否一致
        Area transport = (Area) o;  //再把o对象强制转化为类对象
        return Objects.equals(a, transport.a);  //查看两个对象的属性值是否相等,返回结果
    }
	@Override
	public String toString() {
		return String.valueOf(a);
	}
}
