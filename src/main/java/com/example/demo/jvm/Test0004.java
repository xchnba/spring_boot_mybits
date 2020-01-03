package com.example.demo.jvm;

import java.util.ArrayList;
import java.util.List;

//内存溢出问题
public class Test0004 {
	// 垃圾回收机制基本原则:内存不足的时候回去回收，内存如果足够，暂时不会区回收。 减少回收次数和回收的时间
	// -Xms1m -Xmx50m -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError
	public static void main(String[] args) {
		// List<Object> listObject = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			System.out.println("i:" + i);
			Byte[] bytes = new Byte[1 * 1024 * 1024];
			// listObject.add(bytes);
		}
		System.out.println("添加成功...");

	}

}
