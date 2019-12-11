package com.example.demo.mall.controller.thread;

import org.springframework.jdbc.support.incrementer.PostgresSequenceMaxValueIncrementer;

public class Thread002 extends Thread {
    @Override
    public void run() {
        for (int i=0;i<20;i++){
            System.out.println("子线程运动==="+i);
        }
    }
}

class Thread003 {
    public static void main(String[] args) {
        Thread002 t2 = new Thread002();
        Thread004 t4 = new Thread004();
        t2.start();
        t4.run();
    }
}

class Thread004 implements Runnable{

    @Override
    public void run() {
        for (int i=0;i<20;i++){
            System.out.println("实现runnable接口==="+i);
        }
    }
}