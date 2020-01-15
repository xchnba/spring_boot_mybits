package com.example.demo.sourcecode.hashmap.exthashmap;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class Test001 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		// 基于什么原则 后进选出 非公平锁与公平锁
		ExtHashMap extHashMap = new ExtHashMap<String, String>();
		for (int i = 0; i < 100000; i++) {
			extHashMap.put(i + "", i + "");
		}
		for (int i = 0; i < 100000; i++) {
			extHashMap.get("" + i + "");
			// System.out.println(extHashMap.get("" + i + ""));
		}
		// 70 68 87 75
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		// // 修改3号之后
		// System.out.println(extHashMap.get("3号"));
		// // System.out.println("扩容之前获取数据:" + extHashMap.get("1号"));
		// // extHashMap.print();
		// // System.out.println();
		// // // extHashMap.put(14 + "号", 14 + "号");
		// // // extHashMap.put(1 + "号", "4444号");
		// // System.out.println("扩容之后获取数据:" + extHashMap.get("1号"));

	}

}
