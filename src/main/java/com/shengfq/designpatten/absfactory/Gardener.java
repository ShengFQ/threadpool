package com.shengfq.designpatten.absfactory;
/**
 * 顶级抽象园丁
 * 生产顶级抽象的水果和蔬菜
 * */
public interface Gardener {
	public Fruit createFruit(String name);

	public Veggie createVeggie(String name);
}
