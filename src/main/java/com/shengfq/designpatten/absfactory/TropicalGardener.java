package com.shengfq.designpatten.absfactory;
/**
 * 热带的园丁
 * 生产热带的水果和蔬菜
 * */
public class TropicalGardener implements Gardener {

	@Override
	public Fruit createFruit(String name) {
		return new TropiccalFruit(name);
	}

	@Override
	public Veggie createVeggie(String name) {
		return new TropicalVeggie(name);
	}

}
