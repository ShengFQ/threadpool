package com.shengfq.designpatten.absfactory;

public interface Gardener {
	public Fruit createFruit(String name);

	public Veggie createVeggie(String name);
}
