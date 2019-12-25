package com.example.demo.mall.controller;

import com.example.demo.mall.common.Utils.IdUtils;
import com.example.demo.mall.controller.thread.threadpool.UsersThread;
import com.example.demo.mall.dao.UserDao;
import com.example.demo.mall.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
public class JpaController {
    @Autowired
    UserDao userDao;
    @RequestMapping("/jpainsert")
    @ResponseBody
    public String jpaInsetr(){
        User user = new User();
//        user.setId(IdUtils.getIncreaseIdByCurrentTimeMillis());
//        user.setId(IdUtils.getIncreaseIdByNanoTime());
        user.setId(IdUtils.getRandomIdByUUID());
        user.setName("哈哈");
        user.setAge(20);
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


    @RequestMapping("/addusers")
    @ResponseBody
    public String addusers(){
        long time1 = System.currentTimeMillis();
        System.out.println("刚开始执行方法时候的时间=="+time1);
        UsersThread is = new UsersThread(userDao);
        Thread t1 = new Thread(is);
//        Thread t2= new Thread(is);
        ExecutorService newcash = Executors.newCachedThreadPool();
        newcash.execute(t1);
//        newcash.execute(t2);
        newcash.shutdown();
        long time2 = System.currentTimeMillis();
        System.out.println("执行结束方法时候的时间=="+time2);
        System.out.println("消耗的时间=="+(time2-time1));
        return "插入成功";
    }




}

