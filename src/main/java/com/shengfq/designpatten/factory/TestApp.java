package com.shengfq.designpatten.factory;

/**
 * 工厂方法（Factory Method）模式
 * 比简单工厂多了:具体工厂
 * 总结
 * 简单工厂模式：让一个工厂类负责创建所有对象；但没有考虑后期扩展和维护，修改违背开闭原则，静态方法不能被继承。
 * 工厂方法模式：主要思想是继承，修改符合开闭原则；但每个工厂只能创建一种类型的产品。
 * 抽象工厂模式：主要思想是组合，本质是产品族，实际包含了很多工厂方法，修改符合开闭原则；
 * 但只适用于增加同类工厂这种横向扩展需求，不适合新增功能方法这种纵向扩展。
 *
 * 作者：阿里巴巴大淘宝技术
 * 链接：https://www.zhihu.com/question/24843188/answer/2690577309
 * 来源：知乎
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * */
public class TestApp {
	private ABsFactory factory1, factory2;
	private AbsProduct p1, p2;

	private void test() {
		factory1 = new ConcreteFactoryA();
		factory2 = new ConcreteFactoryB();
		p1 = factory1.createProduct();
		p2 = factory2.createProduct();

		System.out.println("apple product create ");
		p1.grow();
		p1.plant();
		p1.harvest();

		System.out.println("grape product create ");
		p2.plant();
		p2.grow();
		p2.harvest();;
		System.out.println("over");

	}

	public static void main(String[] args) {
		TestApp test = new TestApp();
		test.test();
	}
}
