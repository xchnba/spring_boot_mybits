package com.example.demo.designmode.proxyandfactory.factory;

//发动机
public interface Engine {
	 void run();
}
class EngineA implements Engine{

	public void run() {
	 System.out.println("发动机转速快.");
	}
	
}
class EngineB implements Engine{

	public void run() {
	 System.out.println("发动机转速慢.");
	}
	
}