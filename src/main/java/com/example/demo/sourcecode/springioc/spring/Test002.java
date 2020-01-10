package com.example.demo.sourcecode.springioc.spring;

import com.example.demo.sourcecode.springioc.spring.entity.User;
import org.dom4j.DocumentException;



public class Test002 {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		User user = (User) applicationContext.getBean("user");
		System.out.println(user);
	}

}
