package com.example.demo.designmode.proxyandfactory;

public class Client {

	public static void main(String[] args) {
     CarFactory carFactory=new BydFactory();
     Car byd = carFactory.createCar(null);
     byd.run();
     
     CarFactory jiliFactory=new JILiFactory();
     Car jili = jiliFactory.createCar("吉利");
     jili.run();
	}

}
