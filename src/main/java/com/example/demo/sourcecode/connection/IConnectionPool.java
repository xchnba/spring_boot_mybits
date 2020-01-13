package com.example.demo.sourcecode.connection;

import java.sql.Connection;

//连接数据库池
public interface IConnectionPool {

	// 获取连接(重复利用机制)
	public Connection getConnection();

	// 释放连接(可回收机制)
	public void releaseConnection(Connection connection);
}
