package com.example.demo.sourcecode.mybitsorm.sql;

import java.lang.reflect.Proxy;

import com.example.demo.sourcecode.mybitsorm.orm.mybatis.aop.MyInvocationHandlerMbatis;

public class SqlSession {

	// 加载Mapper接口
	public static <T> T getMapper(Class classz) {
		return (T) Proxy.newProxyInstance(classz.getClassLoader(), new Class[] { classz },
				new MyInvocationHandlerMbatis(classz));
	}

}
