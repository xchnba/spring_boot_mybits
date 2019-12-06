package com.example.demo.mall.controller;

import com.example.demo.mall.mapper.CatoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/catory")
public class CatoryController {
    @Autowired
    CatoryMapper catoryMapper;

    @RequestMapping("/name")
    public String savename (){
        String name = "zhangsan";
        int age= 12;
        String id ="2233swdsass";
        catoryMapper.insert(id,name,age);
        return name;
    }

    @RequestMapping("/ztree")
    public String index (){

        return "/mall/ztree";
    }
}
