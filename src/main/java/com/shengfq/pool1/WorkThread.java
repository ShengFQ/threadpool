package com.shengfq.pool1;

import java.util.concurrent.BlockingQueue;

public class WorkThread extends Thread {
	private BlockingQueue<Task> taskQueue=null;
	private boolean isStopped=false;
	public void setStopped(boolean isStopped) {
		this.isStopped = isStopped;
	}

	public WorkThread(BlockingQueue<Task> queue){
		taskQueue=queue;
	}
	
	@Override
	public void run() {
		while(!isStopped()){
			try{
				Task runnable=taskQueue.take();
				if(runnable==null){
					continue;
				}
				runnable.run();
				runnable.setFinish(true);
				if(runnable.isFinish()){
					runnable.endTask();
				}
			}catch(Exception e){
				//write log bug keep running
			}
		}
		System.out.println("workThread is stoped!");
	}
		
	public synchronized boolean isStopped(){
		return isStopped;
	}
}
