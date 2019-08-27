package demo.shengfq.designpatten.factory;

public class ConcreteFactoryA implements ABsFactory {

	@Override
	public AbsProduct createProduct() {
		System.out.println("create apple");
		return new ConcreteProductA();
	}

}
