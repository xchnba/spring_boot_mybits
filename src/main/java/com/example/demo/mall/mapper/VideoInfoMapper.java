package com.example.demo.mall.mapper;

import com.example.demo.mall.domain.VideoInfo;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import java.util.List;

public interface VideoInfoMapper {
    //传过来应用频道子频道都可以查询，还能支持name模糊查询，状态查询
    @Select("<script>"+
            "select * from video_info"+
            "where category_id in"+
            "(select t2.id from (select * from category t1 where t1.parent_id in (select t.id from category t where t.parent_id in "+
            "<foreach collection='categoryIds' item='id' open='(' separator=',' close=')'>#{id}</foreach>" +
            "or t.id in " +
            "<foreach collection='categoryIds' item='id' open='(' separator=',' close=')'>#{id}</foreach>" +
            ") or t1.id in " +
            "<foreach collection='categoryIds' item='id' open='(' separator=',' close=')'>#{id}</foreach>" +
            ") as t2 where t2.level = 2) "+
            "<if test='status != null'> and status = #{status} </if>"  +
            "<if test='name != null and name !=\"\"'> and name like concat('%', #{name}, '%')</if>" +
            "</script>"
            )
    List<VideoInfo> getVideoinfoByCategory(@Param("categoryIds")List<String> categoryIds, @Param("name") String name, @Param("status") Integer status);
}