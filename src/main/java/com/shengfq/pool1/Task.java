package com.shengfq.pool1;
/**
 * @title 工作任务
 * @author shengfq
 * @date 2020-12-08
 * */
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
	/**
	 * 执行任务
	 * */
	public void startTask(){
		System.out.println("start task...");
		for(int ii=0;ii<100;ii++){
			i=i+1;
		}
		System.out.println("i:"+i);
	}
	
	public void endTask(){
		System.out.println("task is end i:"+i);
	}
}
