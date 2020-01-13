package com.example.demo.sourcecode.mybitsorm.orm.mybatis.aop;


import com.example.demo.mall.domain.User;
import com.example.demo.sourcecode.mybitsorm.mapper.UserormMapper;
import com.example.demo.sourcecode.mybitsorm.sql.SqlSession;

public class Test0003 {

	public static void main(String[] args) {
		// 使用动态代理技术虚拟调用方法
		UserormMapper userMapper = SqlSession.getMapper(UserormMapper.class);
		User selectUser = userMapper.selectUser("批量", 7962);
		System.out.println(
				"结果:" + selectUser.getName() + "," + selectUser.getAge() + ",id:" + selectUser.getId());
		// // 先走拦截invoke
		// int insertUserResult = userMapper.insertUser("张三", 644064);
		// System.out.println("insertUserResult:" + insertUserResult);
	}

}
