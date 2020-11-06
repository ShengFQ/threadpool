package com.shengfq.designpatten.factory;

public interface AbsProduct {
	/**
	 * 种植
	 */
	void plant();

	/**
	 * 生长
	 */
	void grow();

	/**
	 * 收获
	 */
	void harvest();
}
