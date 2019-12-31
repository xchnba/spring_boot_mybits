package com.example.demo.designmode.facade;

public class Client {

	public static void main(String[] args) {
		// AliSmsService aliSmsService= new AliSmsServiceImpl();
		// EamilSmsService eamilSmsService= new EamilSmsServiceImpl();
		// WeiXinSmsService weiXinSmsService= new WeiXinSmsServiceImpl();
		// aliSmsService.sendSms();
		// eamilSmsService.sendSms();
		// weiXinSmsService.sendSms();
		new Computer().sendMsg();
	}

}
