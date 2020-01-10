package com.example.demo.sourcecode.springioc;


import com.example.demo.sourcecode.springioc.service.UserService;
import com.example.demo.sourcecode.springioc.spring.ClassPathXmlApplicationContextAnno;

public class Test001 {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContextAnno app = new ClassPathXmlApplicationContextAnno("com.example.demo.sourcecode.springioc.service.impl");
		UserService userService = (UserService) app.getBean("userServiceImpl");
		userService.add();
	}

}
