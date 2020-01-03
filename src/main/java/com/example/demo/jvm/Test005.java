package com.example.demo.jvm;

//栈溢出
public class Test005 {

	private static int count;

	// 最大深度:10636 244972 10805
	public static void count() {
		try {
			count++;
			// count();
		} catch (Throwable e) {
			System.out.println("最大深度:" + count);
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 20805; i++) {
			count();
		}
	}

}
