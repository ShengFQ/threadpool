package com.bjsxt.base.coll012;

import java.util.*;

/**
 * 多线程使用Vector或者HashTable的示例（简单线程同步问题）
 * @author alienware
 */
public class Tickets {

	public static void main(String[] args) {
		//初始化火车票池并添加火车票:避免线程同步可采用Vector替代ArrayList  HashTable替代HashMap
		//1 使用了默认加锁访问的vector,线程安全
		final Vector<String> tickets = new Vector<String>();


		//2 使用默认不加锁访问的ArrayList,线程不安全,结果显示共享的票池一张票出给了多个调用方
		//List<String> tickets=new ArrayList<String>();


		for(int i = 1; i<= 100; i++){
			tickets.add("火车票"+i);
		}
		
//		for (Iterator iterator = tickets.iterator(); iterator.hasNext();) {
//			String string = (String) iterator.next();
//			tickets.remove(20);
//		}
		
		for(int i = 1; i <=10; i ++){
			new Thread("线程"+i){
				public void run(){
					while(true){
						if(tickets.isEmpty()) break;
						System.out.println(Thread.currentThread().getName() + "---" + tickets.remove(0));
						try {
							Thread.sleep(100);
						}catch(InterruptedException e){
							e.printStackTrace();
						}
					}
				}
			}.start();
		}
	}
}
