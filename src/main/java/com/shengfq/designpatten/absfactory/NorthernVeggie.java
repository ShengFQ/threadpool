package com.shengfq.designpatten.absfactory;

public class NorthernVeggie implements Veggie {
	private String name;

	public NorthernVeggie(String name) {
		System.out.println("亚热带工厂为您创建了：亚热带蔬菜－" + name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
