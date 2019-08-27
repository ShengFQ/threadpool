package demo.shengfq.thread;



public class ThreadDemo implements Runnable{
	private boolean flag;
	private String threadName;
	
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public ThreadDemo(String tName){
		this.threadName=tName;
	}
	@Override
	public void run() {
		try{
			System.out.println("thread running..");
			Thread.sleep(2000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		flag=true;
		System.out.printf("flag= %s ,current thread %s",isFlag(),threadName);
	}
	
}
