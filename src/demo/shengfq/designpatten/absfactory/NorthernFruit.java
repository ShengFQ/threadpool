package demo.shengfq.designpatten.absfactory;

public class NorthernFruit implements Fruit {
	private String name;

	public NorthernFruit(String name) {
		System.out.println("亚热带工厂为您创建了：亚热带水果－" + name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
