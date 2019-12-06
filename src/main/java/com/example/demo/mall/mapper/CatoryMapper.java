package com.example.demo.mall.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface CatoryMapper {
    @Insert("INSERT INTO USERS(ID,NAME, AGE) VALUES(#{id}, #{name}, #{age})")
    int insert(@Param("id") String id,@Param("name") String name, @Param("age") Integer age);
}
