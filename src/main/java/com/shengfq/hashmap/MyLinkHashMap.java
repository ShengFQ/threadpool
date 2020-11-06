package com.shengfq.hashmap;

public class MyLinkHashMap {
	/**
	 * 自定义的hashmap,基本元素采用entry[],entry是链表结构. 基本方法: put(string,string)
	 * get(string)
	 * 
	 * entry<string,string>
	 * */
	private int length = 10;
	private Entry[] entries;
	private int index = 0;

	public MyLinkHashMap() {
		super();
		initinalize();
	}

	public void initinalize() {
		entries = new Entry[length];
	}

	public String put(String key, String value) {
		// 由于是链表存储,添加要加到链表头部,所以要获取头
		// 第一个问题,放到数组中哪个链表呢,这里通过索引计算法,输入因子是key,通过key一定可以获得value存储在哪个索引下
		int index = key.hashCode() % length;
		Entry privious = entries[index];
		// 第二个问题,如果存在的要覆盖,不存在的才加在头部
		for (Entry entry = entries[index]; entry != null; entry = entry.next) {
			if (entry.getKey().equals(key)) {
				String oldvalue = entry.getValue();
				entry.setValue(value);
				return oldvalue;
			}
		}
		Entry entry = new Entry(key, value);
		entry.next = privious;
		entries[index] = entry;
		return null;
	}

	public String get(String key) {
		int index = key.hashCode() % length;
		for (Entry entry = entries[index]; entry != null; entry = entry.next) {
			if (entry.getKey().equals(key)) {
				return entry.value;
			}
		}
		return null;
	}

	public class Entry {
		private String key;
		private String value;
		private Entry next;

		public Entry(String key, String value) {
			this.key = key;
			this.value = value;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public Entry getNext() {
			return next;
		}

		public void setNext(Entry next) {
			this.next = next;
		}

	}
}
