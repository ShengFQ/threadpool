package com.shengfq.pool1;

public class Task extends Thread {
	private  int i;
	private boolean isFinish;	
	public boolean isFinish() {
		return isFinish;
	}
	public void setFinish(boolean isFinish) {
		this.isFinish = isFinish;
	}

	@Override
	public void run() {
		startTask();
	}
	
	public void startTask(){
		System.out.println("start task...");
		for(int ii=0;ii<100;ii++){
			i=i+1;
		}
	}
	
	public void endTask(){
		System.out.println("task is end i:"+i);
	}
}
