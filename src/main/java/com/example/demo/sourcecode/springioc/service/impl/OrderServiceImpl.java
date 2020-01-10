package com.example.demo.sourcecode.springioc.service.impl;


import com.example.demo.sourcecode.springioc.annotation.ExtService;
import com.example.demo.sourcecode.springioc.service.OrderService;

@ExtService
public class OrderServiceImpl implements OrderService {

	@Override
	public void addOrder() {
		System.out.println("addOrder");
	}

}
