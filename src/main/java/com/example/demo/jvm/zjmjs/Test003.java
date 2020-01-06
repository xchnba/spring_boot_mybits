package com.example.demo.jvm.zjmjs;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test003 {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// 1.使用反射技术执行某方法
		Class<?> forName = Class.forName("com.example.demo.jvm.zjmjs.Test003");
		Object newInstance = forName.newInstance();
		Method method = forName.getDeclaredMethod("sum", int.class, int.class);
		method.invoke(newInstance, 1, 5);
	}
	public void sum(int a, int b) {
		System.out.println("sum:" + a + b);
	}


}
