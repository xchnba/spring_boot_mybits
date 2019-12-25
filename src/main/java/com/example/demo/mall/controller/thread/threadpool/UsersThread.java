package com.example.demo.mall.controller.thread.threadpool;

import com.example.demo.mall.common.Utils.IdUtils;
import com.example.demo.mall.dao.UserDao;
import com.example.demo.mall.domain.User;

import java.util.concurrent.atomic.AtomicInteger;


public class UsersThread extends Thread {
    private volatile  int count=1;
    UserDao userDao;
    private Object object=new Object();
    private AtomicInteger atomic  = new AtomicInteger(0);
    public UsersThread(UserDao userDao){
        this.userDao=userDao;
    }
    @Override
    public void run() {

        while (count<5000){
                addUser(count);
            }

//        for (int i = 0;i<5000;i++){
//            addUser(i);
//        }

    }

    private  void addUser(int i) {
        count = atomic.incrementAndGet();
        System.out.println(Thread.currentThread().getName()+"====="+count);
        User user = new User();
        user.setId(IdUtils.getRandomIdByUUID());
        user.setName("批量");
        user.setAge(i);
        userDao.save(user);


    }
}
