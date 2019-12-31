package com.example.demo.designmode.template;

//子类实现模版方法 :取款
public class DrawMoney extends BankTemplateMethod {
	@Override
	void transact() {
		System.out.println("我要取款");
	}
}
