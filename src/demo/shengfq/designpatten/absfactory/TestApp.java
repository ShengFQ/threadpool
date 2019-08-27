package demo.shengfq.designpatten.absfactory;

public class TestApp {
	private void test() {
		Veggie tv, nv;
		Fruit tf, nf;
		TropicalGardener tg = new TropicalGardener();
		NorthernGardener ng = new NorthernGardener();
		tv = tg.createVeggie("热带菜叶");
		nv = ng.createVeggie("东北甜菜");
		tf = tg.createFruit("海南椰子");
		nf = ng.createFruit("雪梨");
	}

	public static void main(String args[]) {
		TestApp test = new TestApp();
		test.test();
	}
}