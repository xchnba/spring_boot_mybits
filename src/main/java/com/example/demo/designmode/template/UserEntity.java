package com.example.demo.designmode.template;

public class UserEntity implements Cloneable {

	private String userName;

	private UserEntity userEntity;
	
	public UserEntity(String userName) {
		super();
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		//浅复制
		//Object obj = super.clone();
		//深复制
		UserEntity user=	(UserEntity)super.clone();
		user.setUserEntity((UserEntity)user.getUserEntity().clone());
		return user;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
}
