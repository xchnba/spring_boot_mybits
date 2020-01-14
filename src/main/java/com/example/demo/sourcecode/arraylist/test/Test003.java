package com.example.demo.sourcecode.arraylist.test;

import com.example.demo.sourcecode.arraylist.ExtArrayList;
import com.example.demo.sourcecode.arraylist.ExtList;

import java.util.Vector;


public class Test003 {

	public static void main(String[] args) {

		// ExtArrayList extArrayList = new ExtArrayList();
		// extArrayList.add("a");
		// extArrayList.add("b");
		// extArrayList.add("c");
		// extArrayList.add("d");
		// extArrayList.add("e");
		// extArrayList.remove("d");
		// // extArrayList.remove(4);
		// for (int i = 0; i < extArrayList.getSize(); i++) {
		// System.out.println(extArrayList.get(i));
		// }
		// 反射机制 不能够获取泛型类型
		ExtList<String> extArrayList = new ExtArrayList<String>(1);
		extArrayList.add("a");
		extArrayList.add("b");
		extArrayList.add("c");
		extArrayList.add("d");
		extArrayList.add("e");
		for (int i = 0; i < extArrayList.getSize(); i++) {
			System.out.println(extArrayList.get(i));
		}

	}

}
