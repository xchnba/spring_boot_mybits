package com.example.demo.mall.controller;

import com.example.demo.mall.common.Utils.IdUtils;
import com.example.demo.mall.controller.thread.threadpool.UsersCallable;
import com.example.demo.mall.controller.thread.threadpool.UsersThread;
import com.example.demo.mall.dao.UserDao;
import com.example.demo.mall.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.concurrent.*;

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
    public String addusers() throws InterruptedException, ExecutionException {
        long time1 = System.currentTimeMillis();
        System.out.println("刚开始执行方法时候的时间=="+time1);
//        UsersThread is = new UsersThread(userDao);
//        Thread t1 = new Thread(is);
//        Thread t2= new Thread(is);
//        Thread t3= new Thread(is);
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3));
//        executor.execute(t1);
//        executor.execute(t2);
//        executor.execute(t3);
//        executor.shutdown();

//        CompletionService<String> completionService = new ExecutorCompletionService<>(executor);
//        Future<String> submit =  completionService.submit(new UsersCallable(userDao));
//        Future<String> ss = completionService.take();
        //定义数据总量的大小
        int total = 20000;
        final  int blockSize = 5000; //每块线程数据的大小
        //计算出分几个线程执行
        int blockCount = total/blockSize;
        int blockRemain = total%blockSize;
        if(blockRemain != 0){
            blockCount = blockCount +1;
        }
        ExecutorService newcash = Executors.newCachedThreadPool();
        ThreadPoolExecutor tpe = ((ThreadPoolExecutor) newcash);

        for(int i=0;i<blockCount;i++){
            newcash.submit(new UsersCallable(userDao,i,blockSize,total));
        }
        newcash.shutdown();
        while (true){
            if(newcash.isTerminated()){//所有子线程都结束
                System.out.println("所有子线程结束耗时=="+(System.currentTimeMillis()-time1));
                break;
            }
        }
//        Future<String> submit = newcash.submit(new UsersCallable(userDao));
//        try {
//            System.out.println(submit.get()) ;
////            System.out.println("take==="+ss) ;
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//        newcash.execute(t1);
//        newcash.execute(t2);
//        newcash.execute(t3);
//        Thread.sleep(3000);
        int activeCount = tpe.getActiveCount();
        System.out.println("当前活动线程数：" + activeCount);

        newcash.shutdown();
//        t1.start();
//        t2.start();
        long time2 = System.currentTimeMillis();
        System.out.println("执行结束方法时候的时间=="+time2);
        System.out.println("主线程结束消耗的时间=="+(time2-time1));
        return "插入成功";
    }




}

