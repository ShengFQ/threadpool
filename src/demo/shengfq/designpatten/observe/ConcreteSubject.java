package demo.shengfq.designpatten.observe;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject {
	private String subjectState;
	List<Observe> observers=new ArrayList<Observe>();
	@Override
	public void attach(Observe observe) {
		observers.add(observe);
	}

	@Override
	public void dettach(Observe objserve) {
		observers.remove(objserve);
	}

	@Override
	public void msgNotify() {
		for(Observe observer:observers){
			observer.update();
		}
	}

	@Override
	public String getState() {
		return subjectState;
	}

	@Override
	public void setState(String state) {
		this.subjectState=state;
	}

}
