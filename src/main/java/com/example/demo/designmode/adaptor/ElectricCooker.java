package com.example.demo.designmode.adaptor;

//日本电饭煲
public class ElectricCooker {

	private JP110VInterface jp110VInterface;//日本电饭煲
	ElectricCooker(JP110VInterface jp110VInterface){
		 this.jp110VInterface=jp110VInterface;
	}
	
	public void cook(){
		jp110VInterface.connect();
		System.out.println("开始做饭了..");
	}

}
