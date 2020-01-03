package com.example.demo.jvm;

//配置新生代和老年代
public class Test003 {

	public static void main(String[] args) {
		// -Xms20m -Xmx20m -XX:SurvivorRatio=2 -XX:+PrintGCDetails
		// -XX:+UseSerialGC -XX:NewRatio=2
		// 新生代与老年代占比 1/2 13696K
		byte[] b = null;
		for (int i = 0; i < 10; i++) {
			b = new byte[1 * 1024 * 1024];
		}

	}

}
