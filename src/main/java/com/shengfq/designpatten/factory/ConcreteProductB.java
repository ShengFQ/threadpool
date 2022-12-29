package com.shengfq.designpatten.factory;

public class ConcreteProductB implements AbsProduct {
	private boolean seedless;// 是否有籽

	@Override
	public void plant() {
		System.out.println("grape has been planted.");
	}

	@Override
	public void grow() {
		System.out.println("grape is growing..");
	}

	@Override
	public void harvest() {
		System.out.println("grape has been harvested.");
	}

	public boolean isSeedless() {
		return seedless;
	}

	public void setSeedless(boolean seedless) {
		this.seedless = seedless;
	}

	public static void log(String msg) {
		System.out.println(msg);
	}
}
