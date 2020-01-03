package com.example.demo.jvm;

//配置新生代比例大小
//-Xms20m -Xmx20m -Xmn1m -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC
public class Test002 {

	public static void main(String[] args) {
		// SurvivorRatio=2 配置新生代中 eden from to 比例关系 2 1 1
		byte[] b = null;
		for (int i = 0; i < 10; i++) {
			b = new byte[1 * 1024 * 1024];
		}

	}

}
