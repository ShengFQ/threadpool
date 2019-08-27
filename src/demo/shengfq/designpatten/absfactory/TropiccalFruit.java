package demo.shengfq.designpatten.absfactory;

public class TropiccalFruit implements Fruit {
	private String name;

	public TropiccalFruit(String name) {
		System.out.println("热带工厂创建热带水果" + name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
