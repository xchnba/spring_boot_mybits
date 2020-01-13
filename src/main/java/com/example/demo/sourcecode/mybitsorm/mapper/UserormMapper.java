package com.example.demo.sourcecode.mybitsorm.mapper;

import com.example.demo.mall.annotion.MytbitsSelect;
import com.example.demo.mall.domain.User;
import com.example.demo.sourcecode.mybitsorm.orm.annotation.ExtInsert;
import com.example.demo.sourcecode.mybitsorm.orm.annotation.ExtParam;
import com.example.demo.sourcecode.mybitsorm.orm.annotation.ExtSelect;

import java.util.List;



public interface UserormMapper {

	@ExtInsert("insert into user(userName,userAge) values(#{userName},#{userAge})")
	public int insertUser(@ExtParam("userName") String userName, @ExtParam("userAge") Integer userAge);

	@ExtSelect("select * from users where name=#{name} and age=#{age} ")
	User selectUser(@ExtParam("name") String name, @ExtParam("age") Integer age);

}
