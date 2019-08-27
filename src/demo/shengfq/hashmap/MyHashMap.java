package demo.shengfq.hashmap;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MyHashMap<K, V> extends HashSet {
	private Set<Myentry<K, V>> entrys = new HashSet<Myentry<K, V>>();

	public void put(K key, V value) {
		Myentry<K, V> myEntry = new Myentry<K, V>();
		myEntry.setKey(key);
		myEntry.setValue(value);
		entrys.add(myEntry);
	}

	public V get(K key) {
		V value = null;
		for (Iterator<Myentry<K, V>> i = entrys.iterator(); i.hasNext();) {
			Myentry<K, V> entry = i.next();
			if (key.equals(entry.getKey())) {
				value = entry.getValue();
				break;
			}
		}
		return value;
	}

	public Set<Myentry<K, V>> entrySet() {
		return entrys;
	}

	public Set<K> keySet() {
		Set<K> set = new HashSet<K>();
		for (Iterator<Myentry<K, V>> i = entrys.iterator(); i.hasNext();) {
			Myentry<K, V> myEntry = i.next();
			set.add(myEntry.getKey());
		}
		return set;

	}

	public String toString() {
		StringBuffer sb = new StringBuffer("[");
		for (Iterator<Myentry<K, V>> i = entrys.iterator(); i.hasNext();) {
			Myentry<K, V> myentry = i.next();
			sb.append(myentry.getKey());
			sb.append("=");
			sb.append(myentry.getValue());
			sb.append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("]");
		return sb.toString();
	}
}
