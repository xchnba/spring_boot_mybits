package com.example.demo.mall.controller.thread;

public class Thread006 extends Thread{

    private int count = 100;
//    private static int count = 100;
    private Object obj = new Object();
//    private static Object obj = new Object();


    public Thread006(){

    }

    public Thread006(String name){
        System.out.println("name=="+name);
        this.setName(name);
    }

    @Override
    public void run() {
            while (count>0){
                synchronized (obj){
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                sale();
            }
    }
    //同步方法
    private synchronized void  sale() {
        synchronized (obj){   //使用同步代码块实现线程同步 //同步中嵌套同步会发生四所现象
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if(count>0){
            System.out.println(Thread.currentThread().getName()+"当前卖的火车票第"+(100-count+1)+"张票");
            count --;
        }
    }

}

class Excute01{
    public static void main(String[] args) throws InterruptedException {
        Thread006 thread006 = new Thread006();
        Thread t1 = new Thread(thread006,"窗口1");
        Thread t2 = new Thread(thread006,"窗口2");
        Thread t3 = new Thread(thread006,"窗口3");
        Thread006 t4 = new Thread006("新的线程对象相当于另外一个火车站");
        Thread006 t5 = new Thread006("新火车站窗");

        t1.start();
        t1.sleep(40);
//        t1.join();
//        t4.start();
//        t5.start();
        t2.start();
//        t2.join();
//        t3.start();

    }
}