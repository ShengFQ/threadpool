package com.shengfq.logger;

public class Test {
	public static void main(String[] args) {
		Subject s=new Subject();
		Target target=new Target(s);
		target.doTarget();
	}
}
