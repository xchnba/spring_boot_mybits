package com.example.demo.designmode;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//反射机制
public class Test0004 {
	public String name;

	private Test0004() {
		System.out.println("无参数构造韩式..");
	}

	public Test0004(String name) {
		System.out.println("name:" + name);
		this.name = name;
	}

	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException {
		Class c1 = Class.forName("com.example.demo.designmode.Test0004");
		// Test0004 newInstance = (Test0004) c1.newInstance();
		// newInstance.name = "張三";
		// System.out.println(newInstance.name);
		Constructor<?> constructor = c1.getConstructor(String.class);
		Test0004 newInstance = (Test0004) constructor.newInstance("張三");
		System.out.println(newInstance.name);
		Field[] fields = c1.getFields();
		for (Field field : fields) {
			System.out.println(field.getName());
		}
		Method[] methods = c1.getMethods();
		for (Method method : methods) {
			System.out.println(method.getName());
		}

	}

}
