package com.example.demo.designmode.proxyandfactory;

//吉利汽车4S店
public class BydFactory implements CarFactory {

	public Car createCar(String name) {
	
		return new BydCar();
	}

}
