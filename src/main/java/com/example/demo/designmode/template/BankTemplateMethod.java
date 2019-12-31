package com.example.demo.designmode.template;

//模板方法
public abstract class BankTemplateMethod {

	// 1.取号排队
	public void takeNumber() {
		System.out.println("取号排队。。");
	}

	// 2.每个子类不同的业务实现，由各自子类实现.
	abstract void transact();

	// 3.评价
	public void evaluate() {
          System.out.println("反馈评价..");
	}
	
	public void process(){
		takeNumber();
		transact();
		evaluate();
	}
}
