package com.example.demo.designmode.proxyandfactory.jdkproxy;
//
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.lang.reflect.Proxy;
//
//import com.itmayeidu.proxy.IUserDao;
//import com.itmayeidu.proxy.UserDaoImpl;
//
////每次生成动态代理类对象时,实现了InvocationHandler接口的调用处理器对象 
//public class InvocationHandlerImpl implements InvocationHandler {
//
//	private Object target;// 目标代理对象
//
//	public InvocationHandlerImpl(Object target) {
//		this.target = target;
//	}
//
//	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//		// 开启事物
//		System.out.println("动态代理-开启事物");
//		Object invoke = method.invoke(target, args);
//		System.out.println("动态代理-提交事物");
//		return invoke;
//	}
//
//	public static void main(String[] args) {
//		 IUserDao iUserDao = new UserDaoImpl();
//		 InvocationHandlerImpl invocationHandlerImpl = new
//		 InvocationHandlerImpl(iUserDao);
//		 //获取类加载器
//		 ClassLoader classLoader = iUserDao.getClass().getClassLoader();
//		 //获取当前实现的接口
//		 Class<?>[] interfaces = iUserDao.getClass().getInterfaces();
//		 //调用动态代理实例
//		 IUserDao userDao = (IUserDao) Proxy.newProxyInstance(classLoader,
//		 interfaces, invocationHandlerImpl);
//		 userDao.add();
//	}
//}
