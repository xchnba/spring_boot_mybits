package com.example.demo.sourcecode.linkdelist;

/**
 * 纯手写LinkedList <br>
 */
public class ExtLinkedList<E> {
	// 链表实际存储元素
	private int size;

	// 第一个元素(头节点,为了查询开始)
	private Node first;
	// 最后一个元素(头节点,为添加开始)
	private Node last;

	// add
	public void add(E e) {
		// 创建节点
		Node node = new Node();
		// 给节点赋值
		node.object = e;
		if (first == null) {
			// 添加第一个元素
			// 给第一个元素赋值node节点赋值
			first = node;
			// 第一个元素头和尾都属于自己
		} else {
			// 添加第二个或以上数据
			node.prev = last;
			// 将上一个元素的next赋值
			last.next = node;
		}
		last = node;
		// 实际长度++FF
		size++;
	}

	public void add(int index, E e) {
		// 下标的验证
		checkElementIndex(index);
		// node2节点
		Node oldNode = getNode(index);
		if (oldNode != null) {
			// node1
			Node oldPrevNode = oldNode.prev;
			// node4
			Node newNode = new Node();
			newNode.object = e;
			// node 4下一个节点node2
			newNode.next = oldNode;
			if (oldPrevNode == null) {
				first = newNode;
			} else {
				// node 4上一个节点node1
				newNode.prev = oldPrevNode;
				// node1的下一个节点node4
				oldPrevNode.next = newNode;
			}

			// node2 上一个节点变为node4
			oldNode.prev = newNode;
			size++;
		}

	}

	// 链表节点存储元素
	private class Node {
		// 存放元素的值
		Object object;
		// 上一个节点Node
		Node prev;
		// 下一个节点Node
		Node next;

	}

	@SuppressWarnings("unused")
	public Object get(int index) {
		// 下标的验证
		checkElementIndex(index);

		return getNode(index).object;
	}

	public Node getNode(int index) {
		// 下标的验证
		checkElementIndex(index);
		Node node = null;
		if (first != null) {
			node = first;// 默认取第0个
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
		}
		return node;
	}

	// 指定下标删除
	public void remove(int index) {
		checkElementIndex(index);
		// 1.先获取当前删除Node节点
		Node oldNode = getNode(index);
		if (oldNode != null) {
			// 2.获取删除元素的上下节点
			// node3
			Node oldNextNode = oldNode.next;
			// node1
			Node oldPrevNode = oldNode.prev;
			// 将node1 的下一个节点变为node3
			if (oldPrevNode == null) {
				// 删除一个元素 从换换头
				first = oldNextNode;
			} else {
				oldPrevNode.next = oldNextNode;
				oldNode.prev = null;
			}

			// 将node3的上一个节点变为node1
			if (oldNextNode == null) {
				last = oldPrevNode;
			} else {
				oldNextNode.prev = oldPrevNode;
				oldNode.next = null;
			}
			oldNode.object = null;// 让垃圾回收机制回收
			size--;
		}
	}

	private void checkElementIndex(int index) {
		if (!isElementIndex(index))
			throw new IndexOutOfBoundsException("查询越界啦！");
	}

	private boolean isElementIndex(int index) {
		return index >= 0 && index < size;
	}

	public int getSize() {
		return size;
	}

	public static void main(String[] args) {
		ExtLinkedList<String> extLinkedList = new ExtLinkedList<String>();
		extLinkedList.add("a");
		extLinkedList.add("b");
		extLinkedList.add("c");
		extLinkedList.add("e");
		// System.out.println("删除之前:" + extLinkedList.get(2)); // C
		extLinkedList.add(3, "f");// fabce
		// System.out.println("删除之后:" + extLinkedList.get(2));// E
		// 其实从头查到尾### 效率不高，查询算法#####折半查找
		for (int i = 0; i < extLinkedList.size; i++) {
			System.out.println(extLinkedList.get(i));
		}
		// System.out.println(extLinkedList.get(2));
	}
}
