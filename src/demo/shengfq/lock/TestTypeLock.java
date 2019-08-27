package demo.shengfq.lock;

/**
 * 练习类锁和对象锁的区别.
 * */
public class TestTypeLock extends Thread {
	private Object lock = new Object();
	private static int jobnumber = 10;
	private int count; // 线程数
	private int account; // 余额数

	public int getCount() {
		return count;
	}

	public int getAccount() {
		return account;
	}

	public TestTypeLock() {
		super.start();
	}

	/**
	 * 类锁1
	 * */
	public synchronized void increment() {
		account++;
	}

	/**
	 * 类锁2
	 * */
	public void increment2() {
		synchronized (TestTypeLock.class) {
			account++;
		}
	}

	/**
	 * 对象锁1
	 * */
	public synchronized void increment3() {
		count++;
	}

	/**
	 * 对象锁2
	 * */
	public void increment4() {
		synchronized (this) {
			count++;
		}
	}

	/**
	 * 私有锁1
	 * */
	public void startTask() {
		synchronized (lock) {
			count++;
		}
	}

	@Override
	public void run() {
		increment();
	}

	public static void main(String[] args) {
		System.out.println("start time=" + System.currentTimeMillis() + "ms");

		for (int i = 0; i < jobnumber; i++) {
			TestTypeLock test = new TestTypeLock();
		}
	}

}
