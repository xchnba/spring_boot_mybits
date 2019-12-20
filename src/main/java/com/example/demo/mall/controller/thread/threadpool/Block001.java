package com.example.demo.mall.controller.thread.threadpool;

import com.mysql.jdbc.TimeUtil;

import java.sql.SQLOutput;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Block001 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(2);
        System.out.println(blockingQueue.offer("张三"));
        System.out.println(blockingQueue.offer("李四",2,TimeUnit.SECONDS));
        System.out.println( blockingQueue.poll(1,TimeUnit.SECONDS));
        //因为队列设置长度为2所以插入第三个数据的时候会先等待两秒如果两秒后插不进去就2秒后返回false
        System.out.println(blockingQueue.offer("王五",2,TimeUnit.SECONDS));
        //如果另外有一个线程在2秒内取出这个队列就可以插入了  生产者消费者的思想
//        blockingQueue.poll(1,TimeUnit.SECONDS);
        System.out.println(blockingQueue.offer("赵六",2,TimeUnit.SECONDS));
    }
}
