package com.example.demo.mall.service;

import com.example.demo.mall.domain.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {
    PageInfo<User> findUserList(int page, int size);

    PageInfo<User> findUserListByAop(int page, int size);
}
