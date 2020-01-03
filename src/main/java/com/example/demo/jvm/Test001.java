package com.example.demo.jvm;

//配置堆内存大小
public class Test001 {

	public static void main(String[] args) {
		byte[] b = new byte[25 * 1024 * 1024];
		System.out.println("分配了25M空间给数组");

		System.out.println("最大内存" + Runtime.getRuntime().maxMemory() / 1024 / 1024 + "M");
		System.out.println("可用内存" + Runtime.getRuntime().freeMemory() / 1024 / 1024 + "M");
		System.out.println("已经使用内存" + Runtime.getRuntime().totalMemory() / 1024 / 1024 + "M");
	}
}
