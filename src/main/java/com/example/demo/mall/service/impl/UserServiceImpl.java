package com.example.demo.mall.service.impl;

import com.example.demo.mall.annotion.LogAnnotation;
import com.example.demo.mall.domain.User;
import com.example.demo.mall.mapper.UserMapper;
import com.example.demo.mall.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public PageInfo<User> findUserList() {
        int page = 1;
        int size = 3;
        PageHelper.startPage(page,size);
        List<User> userList = userMapper.findUserList();
        PageInfo<User> userPageInfo = new PageInfo<User>(userList);
//        PageInfo<User> userPageInfo = userMapper.findUserList();
        return userPageInfo;
    }


    @Override
    @LogAnnotation(desc = "my annotion")
    public PageInfo<User> findUserListByAop(int page, int size) {
//        PageHelper.startPage(page,size);
        List<User> userList = userMapper.findUserList();
        PageInfo<User> userPageInfo = new PageInfo<User>(userList);
//        PageInfo<User> userPageInfo = userMapper.findUserList();
        return userPageInfo;
    }


}
