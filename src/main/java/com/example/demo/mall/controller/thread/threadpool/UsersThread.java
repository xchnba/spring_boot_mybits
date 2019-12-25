package com.example.demo.mall.controller.thread.threadpool;

import com.example.demo.mall.common.Utils.IdUtils;
import com.example.demo.mall.dao.UserDao;
import com.example.demo.mall.domain.User;


public class UsersThread extends Thread {
    private volatile static int count = 50000;
    UserDao userDao;
    public UsersThread(UserDao userDao){
        this.userDao=userDao;
    }
    @Override
    public void run() {
        for (int i = 0;i<count;i++){
            addUser(i);
        }

    }

    private synchronized void addUser(int i) {
        User user = new User();
        user.setId(IdUtils.getRandomIdByUUID());
        user.setName("批量");
        user.setAge(i);
        userDao.save(user);
        count--;
    }
}
