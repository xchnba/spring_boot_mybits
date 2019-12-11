package com.example.demo.mall.controller.thread;

public class Thread001 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<20;i++){
                    System.out.println("子线程运动==="+i);
                }
            }
        });
        t1.start();
//        for (int i=0;i<20;i++){
//            System.out.println("主线程运动==="+i);
//        }
        try {
            t1.join();
            for (int i=0;i<20;i++){
                System.out.println("主线程运动==="+i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
