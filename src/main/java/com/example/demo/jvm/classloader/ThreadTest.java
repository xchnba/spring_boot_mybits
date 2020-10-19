package com.example.demo.jvm.classloader;

import java.util.concurrent.locks.LockSupport;

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        Thread1 th = new Thread1();
        Thread t1 = new Thread(th);
        Thread t2 = new Thread(th);
        t1.setName("线程A");
        t2.setName("线程B");
        t1.start();
        t2.start();
    }
}
