package demo.shengfq.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * 线程池的应用练习
 * */
public class TestThreadPool {
	Object objLock=new Object();
	boolean flag=true;
	int count;//同步访问,必须加锁
	int tasksize=100;
	int poolsize=10;
	//线程池管理器,工作:创建线程池,创建任务队列,添加任务,移除线程	
	//工作线程,工作:循环将任务队列的任务取出来运行.	
	//任务:开始任务,结束任务,设置结束标志,是否结束	
	//线程队列(线程池初始化时就会创建的线程队列,添加预备役线程,传入任务队列的引用),任务队列(通过线程池管理器添加任务,注意要通知解锁.)
	
	public static void main(String[] args) {
		//测试使用线程池执行多个任务的时间消耗,需要将所有任务都执行完成才结算		
		TestThreadPool test=new TestThreadPool();
	}
	
	public TestThreadPool(){
		long start=System.currentTimeMillis();
		ThreadPoolManager manager=new ThreadPoolManager(poolsize);				
			for (int i = 1; i <=tasksize; i++) {
				Task task=new Task();
				manager.addTask(task);
			}
		
		waitAndSleep(5);
		System.out.println("current thread num:"+manager.getThreadNum());		
		long timeofexecute=System.currentTimeMillis()-start;
		manager.clearThreadPool();
		System.out.println("with pool time:"+timeofexecute);
	}
	//等待所有线程执行完毕
	public void waitAndSleep(long l){
		while(true){
			synchronized (objLock) {
				if(count==tasksize){
					break;
				}
			}	
			try {
				Thread.sleep(l);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private class ThreadPoolManager{
		//list拥有自动扩容的机制
		private Vector<WorkThread> threadList;
		private Vector<Task> taskList;
		private int currentThreadNum;
		public int getThreadNum(){
			return currentThreadNum;
		}
		public ThreadPoolManager(int size){
			initPool(size);
		}
		
		public void initPool(int size){
			threadList=new Vector<WorkThread>(size);
			taskList=new Vector<Task>(10);
			synchronized (threadList) {//TODO why
				for (int i = 0; i < size; i++) {
					currentThreadNum++;
					WorkThread thread=new WorkThread(taskList,currentThreadNum);
					this.threadList.add(thread);
					
				}
			}		
		}
		
		public void addTask(Task task){
			synchronized (taskList) {//TODO why
				taskList.add(task);
				taskList.notifyAll();//TODO why
			}
			
		}
		
		public void clearThreadPool(){
			synchronized (threadList) {
				while(threadList!=null && !threadList.isEmpty()){
					WorkThread t=threadList.remove(0);
					t.destroyThread();
					System.out.println("clear thread_"+Thread.currentThread().getName());
					continue;
				}
			}			
		}
	}
	
	private class TaskA extends Task{
		public void startTask(){
			super.startTask();
			System.out.println("");
		}
	}
	
	private class Task {
		private boolean isEnd;
		public Task(){
		}
		public void startTask(){
			//do some work			
			synchronized (objLock) {
				count++;	
				System.out.println("count:"+count);
			}
		}
		public void stopTask(){
			
		}
		
		public boolean isEnd(){
			return this.isEnd;
		}
		
		public void setEnd(boolean flag){
			this.isEnd=flag;
		}
		
	}
	private class WorkThread extends Thread{
		boolean flag;
		Vector<Task> mTaskList;//线程池要执行的任务队列引用
		Task mTask;//当前执行的任务
		int threadNum;
		public WorkThread(Vector<Task> listTask,int i){
			flag=true;
			threadNum=i;
			mTaskList=listTask;
			super.setPriority(i);
			super.start();
		}
		
		public int currentThreadNum(){
			return this.threadNum;
		}
		@Override
		public void run() {
			//在工作线程中运行任务,如果任务为空就等待,如果不为空,就取第一个出来,运行starttask方法,注意手动标志该任务的完成状态,but why
			//运行在while块中的方法,表示所有工作线程会争抢任务来执行
			while(mTaskList!=null && flag){
				synchronized (mTaskList) {
					while(flag && mTaskList.isEmpty()){
						try {
							mTaskList.wait();//如果任务为空,当前线程释放持有的mTaskList对象锁,其他线程就可以持有锁.当前线程继续运行,在这个同步块中,由于失去了锁,
							
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					try{
						System.out.println(Thread.currentThread().getName()+" locked");
						mTask=mTaskList.remove(0);
					}catch(Exception e){
						mTask=null;
					}
					if(mTask==null){
						continue;
					}
					mTask.setEnd(false);
					mTask.startTask();
					if(!mTask.isEnd()){
						mTask.setEnd(true);
						mTask.stopTask();
					}
				}
			}
		}
		
		public void destroyThread(){
			flag=false;
			if(mTask!=null){
				mTask.stopTask();
			}
			synchronized (mTaskList) {
				mTaskList.notifyAll();
				
			}
		}
		
	}
}
