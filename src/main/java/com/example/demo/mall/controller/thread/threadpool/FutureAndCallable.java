package com.example.demo.mall.controller.thread.threadpool;

import java.util.concurrent.*;

public class FutureAndCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //生成一个可缓存的无界非阻塞线程池
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        Future<String> submit = newCachedThreadPool.submit(new TaskCallable());
        System.out.println("1.主线程开始执行");
//        String result = submit.get();
//        System.out.println("2.返回结果是=="+result);
        Thread.sleep(3000);
        int i = 123;
        int b = i+1;
        System.out.println("5.主线程执行计算="+b);
        String result = submit.get();//之前的都不好等待之后的会等待类似ajax异步请求
        System.out.println("2.返回结果是=="+result);
        System.out.println("6.在获取结果之后执行");

    }
}

class TaskCallable implements Callable<String>{

    @Override
    public String call()  {
        System.out.println("3.子线程等待5秒开始执行======开始执行");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("4.子线程等待5秒开始执行======执行结束");
        return "豆子大天才";
    }
}