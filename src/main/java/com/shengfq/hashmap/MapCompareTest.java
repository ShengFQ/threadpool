package com.shengfq.hashmap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MapCompareTest {

	public static Map<String, Integer> hashTable = null;
	public static Map<String, Integer> synchronizedMap = null;
	public static Map<String, Integer> concurrentHashMap = null;

	public static void main(String[] args) throws InterruptedException {
		// 构造一个hashtable
		hashTable = new Hashtable<>();
		performTest(hashTable);
		// 构造一个synchronizemap
		synchronizedMap = Collections
				.synchronizedMap(new HashMap<String, Integer>());
		performTest(synchronizedMap);
		// 构造一个CHM
		concurrentHashMap = new ConcurrentHashMap<>();
		performTest(concurrentHashMap);
	}

	public static void performTest(final Map<String, Integer> map)
			throws InterruptedException {
		System.out.println("Test started for: " + map.getClass());
		long averageTime = 0;
		for (int i = 0; i < 5; i++) {
			long begintime = System.nanoTime();
			ExecutorService service = Executors.newFixedThreadPool(5);
			for (int j = 0; j < 5; j++) {
				service.execute(new Runnable() {
					@Override
					public void run() {
						Integer number = (int) Math.ceil(Math.random() * 550 * 1000);
						Integer value = map.get(String.valueOf(number));
						map.put(String.valueOf(number), number);
					}
				});
			}
			// shutdown the pool
			service.shutdown();
			// Blocks until all tasks have completed execution after a shutdown
			// request
			service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
			long endtime = System.nanoTime();
			long totalTime = (endtime - begintime) / 100000L;
			averageTime += totalTime;
			System.out.println("2500K entried added/retrieved in " + totalTime
					+ " ms");
		}
		System.out.println("For " + map.getClass() + " the average time is "
				+ averageTime / 5 + " ms\n");

	}
}
