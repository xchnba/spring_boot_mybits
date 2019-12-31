package com.example.demo.designmode.decorator;

//房屋基本功能默认实现
public class HouseDecoratorImpl implements House {

	@Override
	public void run() {
		System.out.println("房屋已经交付，为毛坯");
	}

}
