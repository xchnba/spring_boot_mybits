package com.example.demo.designmode.template;

public class Client {

	public static void main(String[] args) throws CloneNotSupportedException {
		// BankTemplateMethod bankTemplate=new DrawMoney();
		// bankTemplate.process();
		// BankTemplateMethod bankTemplateMethod=new BankTemplateMethod() {
		//
		// @Override
		// void transact() {
		// System.out.println("我要存钱.");
		//
		// }
		// };
		// bankTemplateMethod.process();
		UserEntity user1 = new UserEntity("张三");
		System.out.println("user1:" + user1 + ",userName:" + user1.getUserName());
		user1.setUserName("李四");
		UserEntity user2 = (UserEntity) user1.clone();
//	
//		System.out.println("user2:" + user2 + ",userName:" + user2.getUserName());
	}

}
