package com.example.demo.mall.mapper;

import com.example.demo.mall.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentMapper {
    @Select("select * from users where name=#{name}")
    Student getStudentByName(@Param("name") String name);
}
