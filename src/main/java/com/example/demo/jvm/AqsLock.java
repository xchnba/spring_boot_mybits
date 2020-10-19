package com.example.demo.jvm;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AqsLock {

    public static void main(String[] args) {

        String a ="nihao";
        String b=a;
        System.out.println("是否相等==="+a==b);

        Lock lock = new ReentrantLock(true);
        Thread t1 = new Thread("t1"){
            @Override
            public void run() {
                lock.lock();
                System.out.println("t1=========start");
                long l1=  System.currentTimeMillis();
                for (int i= 0;i<500000;i++){
                    System.out.println("t1线程执行的业务代码"+i);
                }
                long l2=  System.currentTimeMillis();
                System.out.println("t1业务执行时间=="+(l2-l1));
                System.out.println("t1=========end");
                lock.unlock();
            }
        };

        Thread t2 = new Thread("t2"){
            @Override
            public void run() {
                lock.lock();
                System.out.println("t2=========start");
                lock.unlock();
            }
        };
//        t1.start();
//        t2.start();

    }
}