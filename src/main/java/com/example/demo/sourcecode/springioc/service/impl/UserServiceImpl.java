package com.example.demo.sourcecode.springioc.service.impl;


import com.example.demo.sourcecode.springioc.annotation.ExtResource;
import com.example.demo.sourcecode.springioc.annotation.ExtService;
import com.example.demo.sourcecode.springioc.service.OrderService;
import com.example.demo.sourcecode.springioc.service.UserService;




//将该类注入到spring容器里面
@ExtService
public class UserServiceImpl implements UserService {
	// 从Spring容器中读取bean
	@ExtResource
	private OrderService orderServiceImpl;

	public void add() {
		orderServiceImpl.addOrder();
		System.out.println("我是使用反射机制运行的方法");
	}

}
