package com.shengfq.designpatten.observe;

public class WObserve implements Observe {
	
	private Subject subject;
	private String observerState;
	public WObserve(Subject subject){
		this.subject=subject;
		observerState=subject.getState();
	}
	@Override
	public void update() {
		System.out.println("subject states:"+observerState);
		System.out.println("Wobserve update");
	}
	
}
