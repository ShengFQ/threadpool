package demo.shengfq.lock;

/**
 * @author sheng
 * @since 2016-12-12
 * @version 1.0 多线程任务执行的时间统计
 */
public class TestMultiThreadTask {
	public Object mylock = new Object();
	public int count = 0;
	int jobsNumber = 200;

	public static void main(String[] args) throws InterruptedException {
		TestMultiThreadTask test;
		test = new TestMultiThreadTask(20000);
	}

	public TestMultiThreadTask(int jobnum) {
		jobsNumber = jobnum;
		long timeNoPool = 0;
		Thread t1 = null;
		Job job = new Job("sheng", 3);
		long start = System.currentTimeMillis();
		for (int i = 0; i < jobsNumber; i++) {
			t1 = new Thread(job);
			t1.start();
			// t1.join(); //没有并发的优势了 TODO
		}

		sleepToWait(5);
		timeNoPool = System.currentTimeMillis() - start;
		System.out.println("without pool: " + timeNoPool);
	}

	/**
	 * 等待所有线程跑结束的判断函数-样板 判断条件,开启的线程数和当前已经完成的线程数是否相等.
	 */
	public void sleepToWait(long l) {
		while (true) {
			synchronized (mylock) {
				if (count == jobsNumber)
					return;
			}
			try {
				// you can change it to wait end of all tasks
				Thread.sleep(l);
			} catch (Exception ex) {
			}
		}
	}

	private class Job implements Runnable {
		String holderName;
		float amount;

		public Job(String name, float amt) {
			holderName = name;
			amount = amt;
		}

		public void deposit(float amt) {
			amount += amt;
		}

		public void withdraw(float amt) {
			amount -= amt;
		}

		public float checkBalance() {
			return amount;
		}

		@Override
		public void run() {
			// 自动锁机制,同步块保证操作的原子性,对变量操作的原子性,加这句,耗时31.不加这句线,耗时34
			// synchronized (holderName) {
			deposit(3);
			withdraw(3);
			// 当前执行完成线程数自增,执行一遍,增加一个线程
			synchronized (mylock) {
				count++;
				//System.out.println("thread " + count + " run result:" + this.holderName + ":" + this.checkBalance());
			}

			// }

		}

	}
}
