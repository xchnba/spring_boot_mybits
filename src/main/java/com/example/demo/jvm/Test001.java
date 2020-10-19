package com.example.demo.jvm;

//配置堆内存大小
public class Test001 {

	public static void main(String[] args) {
		String a = "abc";
		String b = "abc";
		String c = new String("abc");
		System.out.println(a==b);
		System.out.println(b==c);







//        for(int i= 126;i<130;i++){
//        	Integer d = i;
//        	Integer e = i;
//			System.out.println(i + " " +(d==e));
//
//		}

//		float a = 1.22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222f;
//		double c =1.22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222;
//		System.out.println(a);
//		System.out.println(c);
//		byte[] b = new byte[25 * 1024 * 1024];
//		System.out.println("分配了25M空间给数组");
//        System.out.println("最大内存" + Runtime.getRuntime().maxMemory() / 1024 / 1024 + "M");
//		System.out.println("可用内存" + Runtime.getRuntime().freeMemory() / 1024 / 1024 + "M");
//		System.out.println("已经使用内存" + Runtime.getRuntime().totalMemory() / 1024 / 1024 + "M");
	}
}
