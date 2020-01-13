package com.example.demo.sourcecode.connection;

import java.sql.Connection;
import java.util.List;
import java.util.Vector;

/**
 * 白话文描述 数据库连接池实现原理 <br>
 * ####核心参数######<br>
 * 1.空闲线程 容器 没有被使用的连接存放 2.活动线程 容器正在使用的连接<br>
 * ###核心步骤#####<br>
 * 2.1 初始化线程池(初始化空闲线程)<br>
 * 3.1 调用getConnection方法 --- 获取连接 <br>
 * ####3.1.1 先去freeConnection获取当前连接,存放在activeConnection<br>
 * 4.1 调用releaseConnection方法 ----释放连接----资源回收<br>
 * ####4.1.1 获取activeConnection集合连接,转移到 freeConnection集合中<br>
 */
public class Test001 {

	public static void main(String[] args) {
		ThreadConnection threadConnection = new ThreadConnection();
		for (int i = 1; i < 3; i++) {
			Thread thread = new Thread(threadConnection, "线程i:" + i);
			thread.start();
		}
	}

}

class ThreadConnection implements Runnable {

	public void run() {
		for (int i = 0; i < 10; i++) {
			Connection connection = ConnectionPoolManager.getConnection();
			System.out.println(Thread.currentThread().getName() + ",connection:" + connection);
			ConnectionPoolManager.releaseConnection(connection);
		}
	}

}
