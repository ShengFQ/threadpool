package com.shengfq.designpatten.absfactory;

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
