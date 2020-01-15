package com.example.demo.sourcecode.hashmap.exthashmap;

/**
 * 纯手写HashMap集合
 */
public class ExtHashMap<K, V> implements ExtMap<K, V> {

	// 1.定义table 存放HasMap 数组元素 默认是没有初始化容器 懒加载
	Node<K, V>[] table = null;
	// 2. 实际用到table 存储容量 大小
	int size;
	// 3.HashMap默认负载因子，负载因子越小，hash冲突机率越低， 根据每个链表的个数
	float DEFAULT_LOAD_FACTOR = 0.75f;
	// 4.table默认初始大小 16
	static int DEFAULT_INITIAL_CAPACITY = 16; // 16

	public V put(K key, V value) {

		// 1.判断table 数组大小是否为空（如果为空的情况下 ，做初始化操作）
		if (table == null) {
			table = new Node[DEFAULT_INITIAL_CAPACITY];
		}
		// 2. hashMap 扩容机制 为什么要扩容？扩容数组之后，有什么影响？ hahsmap 中是从什么时候开始扩容
		// 实际存储大小=负载因子*初始容量=DEFAULT_LOAD_FACTOR0.75*DEFAULT_INITIAL_CAPACITY16=12
		// 如果size>12的时候就需要开始扩容数组,扩容数组大小之前两倍
		if (size > (DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY)) {
			// 需要开始对table进行属数组扩容
			resize();
		}

		// 3.计算hash值指定下标位置
		int index = getIndex(key, DEFAULT_INITIAL_CAPACITY);
		Node<K, V> node = table[index];
		if (node == null) {
			// 没有发生hash冲突问题--- index冲突
			node = new Node<K, V>(key, value, null);
			size++;
		} else {

			Node<K, V> newNode = node;
			while (newNode != null) {
				// 已经发生hash冲突问题key 直接添加(冲突node)到前面了 不是往后面加
				if (newNode.getKey().equals(key) || newNode.getKey() == key) {
					// hashCodoe 相同，而且equals 相等情况 说明是同一个对象 修改值
					// node.value = value;
					return newNode.setValue(value);
				} else {
					// 继续添加，排在前面 hascode 取模余数相同 index 存放在链表 或者hashCode 相同但是对象不同
					// 新的node 的next 原来的node
					if (newNode.next == null) {
						// 说明遍历到最后一个node ,添加node
						node = new Node<K, V>(key, value, node);
						size++;
					}

				}
				newNode = newNode.next;
			}

		}
		table[index] = node;
		return null;
	}

	// 对table进行扩容
	private void resize() {

		// 1.生成新的table 是之前的两倍的大小 DEFAULT_INITIAL_CAPACITY*2
		Node<K, V>[] newTable = new Node[DEFAULT_INITIAL_CAPACITY << 1];
		// 2.重新计算index索引,存放在新的table里面
		for (int i = 0; i < table.length; i++) {
			// 存放在之前的table 原来的node
			Node<K, V> oldNode = table[i];
			// a 的index=1 b 的index=1
			// a ##
			while (oldNode != null) {
				table[i] = null;// 赋值为null---为了垃圾回收机制能够回收 将之前的node删除
				// 存放在之前的table 原来的node key
				K oldK = oldNode.key;
				// 重新计算index
				int index = getIndex(oldK, newTable.length);
				// 存放在之前的table 原来的node next
				if (oldK.equals("22号") || oldK.equals("66号")) {
					System.out.println("日志记录");
				}
				Node<K, V> oldNext = oldNode.next;
				// 如果ndex 下标在新newTable发生相同的index时候,以链表进行存储 //
				// 原来的node的下一个是最新的（原来的node存放下新的node下一个）
				oldNode.next = newTable[index];
				// 将之前的node赋值给 newTable[index]
				newTable[index] = oldNode;
				// 判断是否继续循环遍历
				oldNode = oldNext;

			}
		}
		// 3.将newtable赋值给老的table
		table = newTable;
		DEFAULT_INITIAL_CAPACITY = newTable.length;
		newTable = null;/// 赋值为null---为了垃圾回收机制能够回收

	}

	public static void main(String[] args) {

		new ExtHashMap<String, String>().test();
	}

	private String age;

	public void test() {
		// ExtHashMap map1 = new ExtHashMap<K, V>();
		// map1.age = "10";
		// ExtHashMap map2 = map1;
		// map.age = "20";
		// System.out.println(map1.age + "," + map2.age);

		// Node[] newTables = new Node[DEFAULT_INITIAL_CAPACITY << 1];
		// Node<String, String> node = new Node<String, String>("001", "001",
		// null);
		// newTables[0] = node;
		// Node<String, String> newNode = new Node<String, String>("002", "001",
		// null);
		// node = newNode;
		// System.out.println(newTables[0] == node);
	}

	// 测试方法.打印所有的链表元素
	void print() {

		for (int i = 0; i < table.length; i++) {
			Node<K, V> node = table[i];
			System.out.print("下标位置[" + i + "]");
			while (node != null) {
				System.out.print("[ key:" + node.getKey() + ",value:" + node.getValue() + "]");
				node = node.next;
				// if (node.next != null) {
				// node = node.next;
				// } else {
				// // 结束循环
				// node = null;
				// }

			}
			System.out.println();
		}

	}

	public int getIndex(K k, int length) {
		int hashCode = k.hashCode();
		// System.out.println("k:" + k + ",hashCode=" + hashCode);
		int index = hashCode % length;
		return index;
	}

	public V get(K k) {

		Node<K, V> node = getNode(table[getIndex(k, DEFAULT_INITIAL_CAPACITY)], k);
		return node == null ? null : node.value;
	}

	public Node<K, V> getNode(Node<K, V> node, K k) {
		while (node != null) {
			if (node.getKey().equals(k)) {
				return node;
			}
			node = node.next;
		}
		return null;
	}

	public int size() {

		return size;
	}

	// 定义节点
	class Node<K, V> implements Entry<K, V> {
		// 存放Map 集合 key
		private K key;
		// 存放Map 集合 value
		private V value;
		// 下一个节点Node
		private Node<K, V> next;

		public Node(K key, V value, Node<K, V> next) {
			super();
			this.key = key;
			this.value = value;
			this.next = next;
		}

		public K getKey() {
			return this.key;
		}

		public V getValue() {
			return this.value;
		}

		public V setValue(V value) {
			// 设置新值的返回老的 值
			V oldValue = this.value;
			this.value = value;
			return oldValue;
		}

	}

}
