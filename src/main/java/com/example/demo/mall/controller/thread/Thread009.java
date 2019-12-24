package com.example.demo.mall.controller.thread;

import java.util.concurrent.atomic.AtomicInteger;

class Zithread extends Thread{
    private volatile int conunt = 1;
    private static AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    public void run() {
            while (conunt<190){
//                System.out.println(Thread.currentThread().getName()+"=="+conunt);
//                getCounts();
                int number = getAtomic();
                System.out.println(Thread.currentThread().getName()+"=="+number);

            }


    }
//乐观锁，cas无所机制
    private int getAtomic() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        conunt = atomicInteger.incrementAndGet();
        return conunt;
    }
  //synchronized是悲观锁效率低 也是重入锁
    private synchronized void getCounts() {
        try {
            System.out.println(Thread.currentThread().getName()+"=="+conunt);
            Thread.sleep(100);
            conunt++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        conunt++;

    }
}

public class Thread009 {
    public static void main(String[] args) {
        Zithread zithread = new Zithread();
        Thread t1 = new Thread(zithread);
        Thread t2 = new Thread(zithread);
        t1.start();
        t2.start();
    }
}
