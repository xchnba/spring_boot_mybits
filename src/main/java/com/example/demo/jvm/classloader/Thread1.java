package com.example.demo.jvm.classloader;

public class Thread1 implements Runnable {
//    private Object o =new Object();
    int num = 1;
    @Override
    public void run() {
        while (true){
            synchronized (this){
                notify();
                if (num <11 ){
                    System.out.println(Thread.currentThread().getName()+"当前数字为="+num);
                    num++;
                }else {
                    break;
                }
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
