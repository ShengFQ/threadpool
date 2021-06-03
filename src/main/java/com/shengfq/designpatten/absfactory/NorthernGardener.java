package com.shengfq.designpatten.absfactory;
/**
 * 亚热带园丁
 * 生产亚热带的水果和蔬菜
 * */
public class NorthernGardener implements Gardener {

	public Fruit createFruit(String name) {
		return new NorthernFruit(name);
	}

	public Veggie createVeggie(String name) {
		return new NorthernVeggie(name);
	}

}
