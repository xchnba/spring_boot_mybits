package com.example.demo.sourcecode.hashmap.ext;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * 基于Arraylist实现hashMap集合<br>
 * 缺点：性能特别低<br>
 */
public class ExtArraylistHashMap<Key, Value> {

	// MAP 存储容量
	private List<Entry<Key, Value>> tables = new ArrayList<Entry<Key, Value>>();
	// map容器实际容量
	// private int size;
	// key、value

	public void put(Key key, Value value) {
		Entry entry = getEntry(key);
		if (entry != null) {
			// 已经存在
			entry.value = value;
		} else {
			Entry newEntry = new Entry(key, value);
			// 2.调用put的时候，将该hash存储对象存入到Arraylist中
			tables.add(newEntry);
		}

	}

	public Value get(Key key) {
		Entry<Key, Value> entry = getEntry(key);
		return entry == null ? null : entry.value;
	}

	public Entry<Key, Value> getEntry(Key key) {
		// 从头查询到尾做优化### 准
		for (Entry<Key, Value> entry : tables) {
			if (entry.key.equals(key)) {
				return entry;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		ExtArraylistHashMap hashMap = new ExtArraylistHashMap<String, String>();
		hashMap.put("a", "aaaa");
		hashMap.put("b", "bbbb");
		hashMap.put("a", "cccc");// key 相同的情况下， 会覆盖
		System.out.println(hashMap.get("a"));
	}

}

// hash存储对象
class Entry<Key, Value> {

	// hashMap集合存储的key
	public Key key;
	// hashMap集合存储的value
	public Value value;

	public Entry(Key key, Value value) {
		super();
		this.key = key;
		this.value = value;
	}

}
