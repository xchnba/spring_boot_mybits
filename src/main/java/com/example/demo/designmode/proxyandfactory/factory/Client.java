package com.example.demo.designmode.proxyandfactory.factory;



public class Client {

	public static void main(String[] args) {
		CarFactory carFactory = new JiLiFactory2();
		Engine createEngine = carFactory.createEngine();
		Chair createChair = carFactory.createChair();
		createEngine.run();
		createChair.run();
	}

}
