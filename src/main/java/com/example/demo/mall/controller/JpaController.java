package com.example.demo.mall.controller;

import com.example.demo.mall.dao.UserDao;
import com.example.demo.mall.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class JpaController {
    @Autowired
    UserDao userDao;
    @RequestMapping("/jpainsert")
    @ResponseBody
    public String jpaInsetr(){
        User user = new User();
        user.setId("3432ee");
        user.setName("王五");
        user.setAge(12);
        userDao.save(user);
        return "插入成功";
    }

    @RequestMapping("/jpafindall")
    @ResponseBody
    public String jpafindall(){
       List<User> userList = userDao.findAll();
        return userList.toString();
    }
//    @RequestMapping("/jpafindByid")
//    @ResponseBody
//    public String jpafindByid(){
//        User user = new User();
////        User userList = userDao.findOne(user);
////        return userList.toString();
//    }
}

