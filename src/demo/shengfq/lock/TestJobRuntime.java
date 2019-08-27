package demo.shengfq.lock;
/**
 * 统计多线程完成任务的时间总和.
 * */
public class TestJobRuntime {
	Object objLock=new Object();
	int jobnumber=1;
	int threadnum=0;
	//definition jobs
	private class Jobs implements Runnable{

		public Jobs(int t){
			target=t;
		}
		private int target;
		private int amount;
		
		public void increment(int a){
			amount+=a;
		}
		
		public void decrement(int a){
			amount-=a;
		}
		
		public int balance(){
			return amount;
		}
		@Override
		public void run() {
			while(true){
				if(amount==target){
					break;
				}
				if(amount>target){
					decrement(1);
				}else{
					increment(1);	
				}
			}
			//线程执行次数
			synchronized (objLock) {
				threadnum++;
			}
		}
		
	}
	//waitandsleep
	public void waitAndSleep(long l){
		while(true){
			synchronized(objLock){
				if(jobnumber==threadnum){
					System.out.println("wait complete! "+threadnum);
					return ;
				}
			}
			try {
				Thread.sleep(l);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	//init	
	public TestJobRuntime(int jobnum){
		jobnumber=jobnum;
		Jobs run=	new Jobs(500);
		long start=System.currentTimeMillis();
		for(int i=0;i<jobnum;i++){
			//使用循环创建多个线程
			Thread t1=new Thread(run);
			t1.start();
		}
		waitAndSleep(5);
		long time=System.currentTimeMillis()-start;
		System.out.println("without pool time:"+time);
	}
	
	public static void main(String[] args) {
		TestJobRuntime time=new TestJobRuntime(300);
	}
}
