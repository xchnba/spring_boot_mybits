package com.example.demo.designmode.proxyandfactory.proxy;

// 静态代理  静态需要生成代理对象
public class UserDaoProxy implements IUserDao {
	private IUserDao iUserDao;

	public UserDaoProxy(IUserDao iUserDao) {
		this.iUserDao = iUserDao;
	}

	public void add() {
		System.out.println("开启事物");
		iUserDao.add();
		System.out.println("提交事物");
	}

	public void save() {
		System.out.println("开启事物");
		iUserDao.save();
		System.out.println("提交事物");
	}

}
