package com.example.demo.sourcecode.smvcode.ext.springnvc;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 手写springmvc 原理分析<br>
 * 1.创建一个前端控制器（）ExtDispatcherServlet 拦截所有请求(springmvc 基于servlet实现)<br>
 * ####2.初始化操作重写servlet init 方法<br>
 * #######2.1 将扫包范围所有的类,注入到springmvc容器里面，存放在Map集合中 key为默认类名小写，value 对象<br>
 * #######2.2 将url映射和方法进行关联 <br>
 * ##########2.2.1 判断类上是否有注解,使用java反射机制循环遍历方法 ,判断方法上是否存在注解，进行封装url和方法对应存入集合中<br>
 * ####3.处理请求 重写Get或者是Post方法 <br>
 * ##########3.1
 * 获取请求url,从urlBeans集合获取实例对象,获取成功实例对象后,调用urlMethods集合获取方法名称,使用反射机制执行 2. 作者:
 * 每特教育-余胜军<br>
 * 联系方式:QQ644064779|WWW.itmayiedu.com<br>
 */
public class Test {
	// springmvc 容器对象 key:类名id ,value 对象
	private ConcurrentHashMap<String, Object> springmvcBeans = new ConcurrentHashMap<String, Object>();
	// springmvc 容器对象 keya:请求地址 ,vlue类
	private ConcurrentHashMap<String, Object> urlBeans = new ConcurrentHashMap<String, Object>();
	// springmvc 容器对象 key:请求地址 ,value 方法名称
	private ConcurrentHashMap<String, Object> urlMethods = new ConcurrentHashMap<String, Object>();

}
