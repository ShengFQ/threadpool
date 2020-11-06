package com.shengfq.designpatten.factory;

public class ConcreteFactoryB implements ABsFactory {

	@Override
	public AbsProduct createProduct() {
		System.out.println("create grape");
		return new ConcreteProductB();
	}
}
