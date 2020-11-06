package com.shengfq.designpatten.absfactory;

public class TropicalVeggie implements Veggie {
	private String name;

	public TropicalVeggie(String name) {
		System.out.println("热带工厂创建热带蔬菜 " + name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
