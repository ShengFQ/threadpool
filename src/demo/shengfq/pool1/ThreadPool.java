package demo.shengfq.pool1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
	private BlockingQueue<Task> taskQueue=null;
	private List<WorkThread> threads=new ArrayList<WorkThread>();
	private boolean isStopped=false;
	public ThreadPool(int noOfThreads,int maxNoOfTasks){
		taskQueue=new LinkedBlockingQueue<Task>(maxNoOfTasks);
		for(int i=0;i<noOfThreads;i++){
			threads.add(new WorkThread(taskQueue));
		}
		for(WorkThread thread:threads){
			thread.start();
		}
	}
	
	public  void addTask(Task task){
		if(this.isStopped) throw
		new IllegalStateException("thread pool is stopped");
		this.taskQueue.add(task);
	}
	
	public  boolean closeThread(){
		this.isStopped=true;
			while(!threads.isEmpty()){
				WorkThread t=threads.remove(0);
				t.setStopped(true);
			}		
		return this.isStopped;
	}
}
