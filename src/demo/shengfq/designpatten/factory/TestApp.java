package demo.shengfq.designpatten.factory;

/**
 * 工厂方法（Factory Method）模式
 * */
public class TestApp {
	private ABsFactory factory1, factory2;
	private AbsProduct p1, p2;

	private void test() {
		factory1 = new ConcreteFactoryA();
		factory2 = new ConcreteFactoryB();
		p1 = factory1.createProduct();
		p2 = factory2.createProduct();
	}

	public static void main(String[] args) {
		TestApp test = new TestApp();
		test.test();
	}
}
