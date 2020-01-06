package com.example.demo.jvm.zjmjs;

import java.lang.reflect.Method;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

//动态修改字节码文件
public class Test004 {

	public static void main(String[] args) {
		try {
			ClassPool pool = ClassPool.getDefault();
			// 读取com.itmayiedu.User
			CtClass userClass = pool.get("com.example.demo.jvm.zjmjs");
			CtMethod method = new CtMethod(CtClass.voidType, "sum", new CtClass[] { CtClass.intType, CtClass.intType },
					userClass);
			method.setBody("{System.out.println(\"sun:\" + ($1 + $2));}");
			// 添加方法
			userClass.addMethod(method);
			userClass.writeFile("F:/test");
			// 动态执行方法
			Class clazz = userClass.toClass();
			Object newInstance = clazz.newInstance();

			Method sumMethod = clazz.getDeclaredMethod("sum", int.class, int.class);
			System.out.println("开启事物");
			sumMethod.invoke(newInstance, 2, 5);
			// 使用 javassist 实现动态代理。
			System.out.println("提交事物");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
