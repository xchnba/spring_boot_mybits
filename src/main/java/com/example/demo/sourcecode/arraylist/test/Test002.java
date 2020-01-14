package com.example.demo.sourcecode.arraylist.test;

import com.example.demo.sourcecode.arraylist.ExtArrayList;

import java.util.ArrayList;



public class Test002 {

	public static void main(String[] args) {
		// 1.jdk 1.7之后 数组默认数据大小代码存放在add方法 (JDK1.6的时候 默认构造函数初始化elementData大小)
		// 2.arraylist底层采用数组实现 数组名称elementData
		// 3.arraylist底层数组默认初始化为10
		// ExtArrayList extArrayList = new ExtArrayList();
		// extArrayList.get(index)
		// 原来本身elementData容量大小 2
		// int oldCapacity = 1;
		// // 新数据容量大小 (oldCapacity >> 1)=oldCapacity/
		// int newCapacity = oldCapacity + (oldCapacity >> 1);// (2+2/2)=3
		// System.out.println(newCapacity);

		// ArrayList arrayList = new ArrayList<String>();
		//// arrayList.get("");
		// arrayList.add("")
		// ExtArrayList extArrayList = new ExtArrayList(2);
		// extArrayList.add("张三");
		// extArrayList.add("李四");
		// extArrayList.add("王武");
		// System.out.println(extArrayList.get(0));
		ExtArrayList extArrayList = new ExtArrayList(1);
		extArrayList.add("11");
		extArrayList.add("5444");
		extArrayList.add("789");
		System.out.println(extArrayList.get(0));
	}

}
