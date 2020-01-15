package com.example.demo.mall.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.mall.domain.Student;
import com.example.demo.mall.domain.User;
import com.example.demo.mall.mapper.StudentMapper;
import com.example.demo.mall.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    UserService userService;

    @RequestMapping("/getStudent")
    @ResponseBody
    public Student getStudent(String name){
        Student student = studentMapper.getStudentByName("douzi");
        return student;

    }

    //将JavaBean转成json对象
    @RequestMapping("/toJSON")
    @ResponseBody
    public String coventoJson(){
        Student student = new Student();
        student.setName("哈哈哈哈");
        student.setAge(19);
        Object object = JSON.toJSON(student);
        System.out.println(object.toString());
        return object.toString();
    }

    @RequestMapping("/findUserList")
    @ResponseBody
    public PageInfo<User> findUserList(String name){
//        Student student = studentMapper.getStudentByName("douzi");
        // 使用动态代理技术虚拟调用方法

         User student = studentMapper.selectUser("批量", 7962);
//        User selectUser = userMapper.selectUser("批量", 7962);
        int page = 1;
        int size = 10;
        Page<User> st = new Page<>(1,2);
        Map<String,String> map = new HashMap<>();
        map.put("kuorong","123");
//        PageInfo<User> userList = userService.findUserList(page,size);
//        PageInfo<User> userList = userService.findUserListByAop(page,size);
        PageInfo<User> userList = userService.findUserListByPageObj(st);
        return userList;

    }



}
