package com.example.demo.designmode.proxyandfactory.factory;

// 座椅
public interface Chair {

	void run();

}

class ChairA implements Chair {

	public void run() {
		System.out.println("自动加热");
	}

}
class ChairB implements Chair {

	public void run() {
		System.out.println("不能加热");
	}

}