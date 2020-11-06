package com.shengfq.pool1;

public class TestThreadPool {
	public static void main(String[] args) {
		int poolSize = 20;
		int jobs = 20;
		long timePool = 0;
		args = new String[] { "10", "50" };
		if (args.length < 2) {
			System.err.println("Usage: java TestThreadPool " + "<Size of ThreadPool> <jobs> ");
			System.exit(-1);
		}
		try {
			poolSize = Integer.parseInt(args[0]);
			jobs = Integer.parseInt(args[1]);
		} catch (Exception ex) {
			System.out.println("Please input integer.");
			System.exit(-1);
		}
		long start = System.currentTimeMillis();
		System.err.println("Begin of  creating pool");
		ThreadPool pool=new ThreadPool(poolSize, jobs);
		System.err.println("End of  creating pool");
		System.err.println("Begin of testing the strategy  -- pool");
		start = System.currentTimeMillis();
		for(int i=0;i<jobs;i++){
			Task task=new Task();
			pool.addTask(task);
		}
			System.out.println("pool time:" + (System.currentTimeMillis() - start));
		timePool = System.currentTimeMillis() - start;
		System.err.println("End of thread pool test");
		System.out.println("with pool: " + timePool);
		pool.closeThread();
		//System.exit(0);
	}
}
