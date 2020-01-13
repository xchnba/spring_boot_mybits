package com.example.demo.mall.mapper;

import com.example.demo.mall.annotion.LogAnnotation;
import com.example.demo.mall.annotion.MytbitsSelect;
import com.example.demo.mall.domain.Student;
import com.example.demo.mall.domain.User;
import com.example.demo.sourcecode.mybitsorm.orm.annotation.ExtParam;
import com.example.demo.sourcecode.mybitsorm.orm.annotation.ExtSelect;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentMapper {
    @Select("select * from users where name=#{name}")
    Student getStudentByName(@Param("name") String name);

    @ExtSelect("select * from users where name=#{name} and age=#{age} ")
    @MytbitsSelect(desc = "myannotion")
    User selectUser(@ExtParam("name") String name, @ExtParam("age") Integer age);
}
