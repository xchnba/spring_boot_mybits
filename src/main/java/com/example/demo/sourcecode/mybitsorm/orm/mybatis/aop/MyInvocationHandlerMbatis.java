package com.example.demo.sourcecode.mybitsorm.orm.mybatis.aop;

import com.example.demo.common.utils.SQLUtils;
import com.example.demo.sourcecode.mybitsorm.orm.annotation.ExtInsert;
import com.example.demo.sourcecode.mybitsorm.orm.annotation.ExtParam;
import com.example.demo.sourcecode.mybitsorm.orm.annotation.ExtSelect;
import com.example.demo.sourcecode.mybitsorm.orm.utils.JDBCUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;



/**
 * 使用反射动态代理技术 拦截接口防范
 */
public class MyInvocationHandlerMbatis implements InvocationHandler {
	private Object object;

	public MyInvocationHandlerMbatis(Object object) {
		this.object = object;
	}

	// proxy 代理对象 method拦截方法 args方法上的参数值
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("使用动态代理技术拦截接口方法开始");
		// 使用白话问翻译,@ExtInsert封装过程
		// 1. 判断方法上是否存在@ExtInsert
		ExtInsert extInsert = method.getDeclaredAnnotation(ExtInsert.class);
		if (extInsert != null) {
			return extInsert(extInsert, proxy, method, args);
		}
		// 2.查询的思路
		// 1. 判断方法上是否存 在注解
		ExtSelect extSelect = method.getDeclaredAnnotation(ExtSelect.class);
		if (extSelect != null) {
			// 2. 获取注解上查询的SQL语句
			String selectSQL = extSelect.value();
			// 3. 获取方法上的参数,绑定在一起
			ConcurrentHashMap<Object, Object> paramsMap = paramsMap(proxy, method, args);
			// 4. 参数替换？传递方式
			List<String> sqlSelectParameter = SQLUtils.sqlSelectParameter(selectSQL);
			// 5.传递参数
			List<Object> sqlParams = new ArrayList<>();
			for (String parameterName : sqlSelectParameter) {
				Object parameterValue = paramsMap.get(parameterName);
				sqlParams.add(parameterValue);
			}
			// 6.将sql语句替换成?
			String newSql = SQLUtils.parameQuestion(selectSQL, sqlSelectParameter);
			System.out.println("newSQL:" + newSql + ",sqlParams:" + sqlParams.toString());

			// 5.调用jdbc代码底层执行sql语句
			// 6.使用反射机制实例对象### 获取方法返回的类型，进行实例化
			// 思路:
			// 1.使用反射机制获取方法的类型
			// 2.判断是否有结果集,如果有结果集，在进行初始化
			// 3.使用反射机制,给对象赋值

			ResultSet res = JDBCUtils.query(newSql, sqlParams);
			// 判断是否存在值
			if (!res.next()) {
				return null;
			}
			// 下标往上移动移位
			res.previous();
			// 使用反射机制获取方法的类型
			Class<?> returnType = method.getReturnType();
			Object object = returnType.newInstance();
			while (res.next()) {
				// 获取当前所有的属性
				Field[] declaredFields = returnType.getDeclaredFields();
				for (Field field : declaredFields) {
					String fieldName = field.getName();
					Object fieldValue = res.getObject(fieldName);
					field.setAccessible(true);
					field.set(object, fieldValue);
				}
				// for (String parameteName : sqlSelectParameter) {
				// // 获取参数值
				// Object resultValue = res.getObject(parameteName);
				// // 使用java的反射值赋值
				// Field field = returnType.getDeclaredField(parameteName);
				// // 私有方法允许访问
				// field.setAccessible(true);
				// field.set(object, resultValue);
				// }
			}
			return object;
		}

		return null;
	}

	private Object extInsert(ExtInsert extInsert, Object proxy, Method method, Object[] args) {
		// 方法上存在@ExtInsert,获取他的SQL语句
		// 2. 获取SQL语句,获取注解Insert语句
		String insertSql = extInsert.value();
		// System.out.println("insertSql:" + insertSql);
		// 3. 获取方法的参数和SQL参数进行匹配
		// 定一个一个Map集合 KEY为@ExtParamValue,Value 结果为参数值
		ConcurrentHashMap<Object, Object> paramsMap = paramsMap(proxy, method, args);
		// 存放sql执行的参数---参数绑定过程
		String[] sqlInsertParameter = SQLUtils.sqlInsertParameter(insertSql);
		List<Object> sqlParams = sqlParams(sqlInsertParameter, paramsMap);
		// 4. 根据参数替换参数变为?
		String newSQL = SQLUtils.parameQuestion(insertSql, sqlInsertParameter);
		System.out.println("newSQL:" + newSQL + ",sqlParams:" + sqlParams.toString());
		// 5. 调用jdbc底层代码执行语句
		return JDBCUtils.insert(newSQL, false, sqlParams);
	}

	private List<Object> sqlParams(String[] sqlInsertParameter, ConcurrentHashMap<Object, Object> paramsMap) {
		List<Object> sqlParams = new ArrayList<>();
		for (String paramName : sqlInsertParameter) {
			Object paramValue = paramsMap.get(paramName);
			sqlParams.add(paramValue);
		}
		return sqlParams;
	}

	private ConcurrentHashMap<Object, Object> paramsMap(Object proxy, Method method, Object[] args) {
		ConcurrentHashMap<Object, Object> paramsMap = new ConcurrentHashMap<>();
		// 获取方法上的参数
		Parameter[] parameters = method.getParameters();
		for (int i = 0; i < parameters.length; i++) {
			Parameter parameter = parameters[i];
			ExtParam extParam = parameter.getDeclaredAnnotation(ExtParam.class);
			if (extParam != null) {
				// 参数名称
				String paramName = extParam.value();
				Object paramValue = args[i];
				// System.out.println(paramName + "," + paramValue);
				paramsMap.put(paramName, paramValue);
			}
		}
		return paramsMap;
	}

	public Object extInsertSQL() {
		return object;
	}
}
