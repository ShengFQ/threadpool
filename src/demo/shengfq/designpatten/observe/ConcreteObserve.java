package demo.shengfq.designpatten.observe;
/**
 * 订阅者角色:
 * 监听器
 * */
public class ConcreteObserve implements Observe{
	private Subject subject;
	private String observerState;
	@Override
	public void update() {
		System.out.println("subject states:"+observerState);
		System.out.println("concreteobserver update");
	}
	public ConcreteObserve(Subject sub){
		this.subject=sub;
		observerState=subject.getState();
	}
	
	
}
