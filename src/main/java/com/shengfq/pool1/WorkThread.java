package com.shengfq.pool1;

import java.util.concurrent.BlockingQueue;
/**
 * @title 工作线程 消费者
 * @author shengfq
 * @date 2020-12-08
 * */
public class WorkThread extends Thread {
	/**
	 * 阻塞队列
	 * 存储任务
	 * */
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
