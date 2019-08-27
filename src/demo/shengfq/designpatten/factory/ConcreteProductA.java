package demo.shengfq.designpatten.factory;

public class ConcreteProductA implements AbsProduct {

	@Override
	public void plant() {
		// TODO Auto-generated method stub
		System.out.println("apple has been planted.");
	}

	@Override
	public void grow() {
		// TODO Auto-generated method stub
		System.out.println("apple is growing.");
	}

	@Override
	public void harvest() {
		// TODO Auto-generated method stub
		System.out.println("apple has benn harvested.");
	}

}
