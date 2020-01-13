package com.example.demo.sourcecode.mybitsorm.orm.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JdbcTest {

	public static void main(String[] args) throws SQLException {
		// #{ mybatis 替换成?
		// String inserSql = "insert into user(userName,userAge) values(?,?)";
		// ArrayList<Object> arrayList = new ArrayList<>();
		// arrayList.add("余胜军");
		// arrayList.add(20);
		// int insert = JDBCUtils.insert(inserSql, false, arrayList);
		// System.out.println("insert:" + insert);

		// 查询语句
		ArrayList<Object> arrayList = new ArrayList<>();
		arrayList.add("批量");
		arrayList.add(7962);
		ResultSet res = JDBCUtils.query("select * from users where name=? and age=? ", arrayList);
		while (res.next()) {
//			Integer id = res.getInt("id");
			String id = res.getString("id");
			String userName = res.getString("name");
			System.out.println("id:" + id + ",userName:" + userName);
		}
	}

}
