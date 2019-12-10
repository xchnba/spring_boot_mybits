package com.example.demo.mall.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.mall.domain.Student;
import com.example.demo.mall.domain.User;
import com.example.demo.mall.mapper.StudentMapper;
import com.example.demo.mall.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.PublicKey;
import java.util.List;

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
        Student student = studentMapper.getStudentByName("douzi");
//        PageInfo<User> userList = userService.findUserList();
        int page = 1;
        int size = 4;
        PageInfo<User> userList = userService.findUserListByAop(page,size);
        return userList;

    }



}
