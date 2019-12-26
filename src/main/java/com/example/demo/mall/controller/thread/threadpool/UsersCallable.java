package com.example.demo.mall.controller.thread.threadpool;

import com.example.demo.mall.common.Utils.IdUtils;
import com.example.demo.mall.dao.UserDao;
import com.example.demo.mall.domain.User;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class UsersCallable implements Callable<String> {
    private volatile  int count=0;
    private volatile  int block=0;
    UserDao userDao;
    private Object object=new Object();
    private AtomicInteger atomic  = new AtomicInteger(0);
    public UsersCallable(UserDao userDao){
        this.userDao=userDao;
    }

    public UsersCallable(UserDao userDao, int i, int blockSize, int total) {
        this.userDao=userDao;
        if(i == 0){
            this.count = i;
            this.block = blockSize;
        }else {
            this.count = i*blockSize;
            int number = (i+1)*blockSize;
            if(number>total){
                this.block = total;
            }else {
                this.block = number;
            }
        }

    }



    @Override
    public String call() throws Exception {
        long time3 = System.currentTimeMillis();
        while (count<block){
            addUser(count);
        }
        long time4 = System.currentTimeMillis();
        System.out.println("执行结束方法时候的时间time4=="+time4);
        System.out.println("消耗的时间=="+(time4-time3));
        return "callable结束耗时="+(time4-time3);
    }
    private  void addUser(int i) {
//        count = atomic.incrementAndGet();
//        System.out.println(Thread.currentThread().getName()+"====="+count);
        User user = new User();
        user.setId(IdUtils.getRandomIdByUUID());
        user.setName("批量");
        user.setAge(i);
        userDao.save(user);
        count ++;
    }
}
