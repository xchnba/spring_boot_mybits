package com.example.demo.sourcecode.hashmap;

import java.util.LinkedList;

/**
 * 基于LinkedList实现HashMap(效率低)<br>
 * jdk 1.7的时候，hasmap使用数组+链表方式实现<br>
 */
@SuppressWarnings("rawtypes")
public class LinkedListHashMap {

	// Map存放Entry对象
	@SuppressWarnings("unchecked")
	LinkedList<Entry>[] tables = new LinkedList[998];

	// 如果hashCode相同的对象链表结合中
	@SuppressWarnings("unchecked")
	public void put(Object key, Object value) {
		Entry newEntry = new Entry(key, value);
		int hashCode = key.hashCode();// 97
		// hash取模，获取余数
		int hash = hashCode % tables.length;// 998 998以内 00997
		// 1.获取该下标元素,是否有LinkedList
		LinkedList<Entry> entryLinkedList = tables[hash];
		if (entryLinkedList == null) {
			// 没有hash冲突
			entryLinkedList = new LinkedList<Entry>();
			entryLinkedList.add(newEntry);
			// tables数组
			tables[hash] = entryLinkedList;
		} else {
			for (Entry entry : entryLinkedList) {
				if (entry.key.equals(key)) {
					// equals相等,hashCode 一定相同 说明:是同一个对象
					entry.value = value;// 直接覆盖
				} else {
					// hashCode 相同，对象的值不一定相同
					// 发生hash冲突问题，直接在后面继续添加链表节点
					entryLinkedList.add(newEntry);
				}
			}

		}
	}

	// hash算法
	// System.out.println(hash);
	// 两个对象做比较的时候,如果hashCode相同，对象的值是否一定相同 不一定相同
	// 两个对象做比较的时候,如果 equals比较相同，对象的值是否一定相同 相同

	// 查询直接使用hash值直接定位在数组那个位置
	public Object get(Object key) {
		int hashCode = key.hashCode();// 97
		// hash取模，获取余数
		int hash = hashCode % tables.length;// 998 998以内 00997
		LinkedList<Entry> linkedList = tables[hash];
		for (Entry entry : linkedList) {
			if (entry.key.equals(key)) {
				return entry.value;
			}
		}
		return tables[hash];
	}

	public static void main(String[] args) {
		LinkedListHashMap linkedListHashMap = new LinkedListHashMap();
		linkedListHashMap.put("a", "aaaa");
		linkedListHashMap.put("a", "ccccc");// 覆盖
		System.out.println(linkedListHashMap.get("a"));
	}

}

// hash存储对象
class Entry<Key, Value> {

	// hashMap集合存储的key
	Key key;
	// hashMap集合存储的value
	Value value;

	public Entry(Key key, Value value) {
		super();
		this.key = key;
		this.value = value;
	}

}