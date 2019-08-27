package demo.shengfq.designpatten.observe;

public class TestObserve {
	public static void main(String[] args) {
		Subject sub=new ConcreteSubject();
		sub.setState("sub is update");
		ConcreteObserve cObserve=new ConcreteObserve(sub);
		ConcreteObserve sObserve=new ConcreteObserve(sub);
		WObserve wObserve=new WObserve(sub);
		sub.attach(cObserve);
		sub.attach(sObserve);
		sub.attach(wObserve);
		sub.msgNotify();
	}
}
