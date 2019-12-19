package com.example.demo.mall.controller.thread;

import java.awt.image.VolatileImage;

class Ses {
    String name;
    String sex;
    boolean falg = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}

//生产者
class ProductThread extends Thread {
    private Ses ses;

    public ProductThread(Ses ses) {
        this.ses = ses;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            synchronized (ses){//wait 和notify都在synchronized内部
                if(ses.falg){ //初始化为false
                    try {
                        ses.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(count == 0){   //首先写入
                    ses.setName("小军");
                    ses.setSex("男");
                }else{
                    ses.setName("小红");
                    ses.setSex("女");
                }
                count = (count+1)%2;
                ses.falg = true;//标记当前线程为等待
                ses.notify();//唤醒被等待的线程
            }
        }

    }
}
//消费者
class ConsumThread extends Thread{
    private Ses ses;
    public ConsumThread(Ses ses){
        this.ses = ses;
    }
    @Override
    public void run() {

        while (true){
            synchronized (ses){
                if(!ses.falg){ //初始化为false 所以非就是true进入
                    try {
                        ses.wait();  //该线程进入等待，释放当前对象锁先等待写入
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+ses.getName()+ses.getSex());
                ses.falg = false;
                ses.notify();
            }

        }

    }
}

public class Thread008 {
    public static void main(String[] args) {
        Ses ses = new Ses();
        ProductThread ps = new ProductThread(ses);
        ConsumThread cs = new ConsumThread(ses);
        ConsumThread scs = new ConsumThread(ses);
        ps.start();
        cs.start();
//        scs.start(); //一个生产者多个消费者会出现重复消费 就是两个消费者互相notify而生产没有获得锁对象
    }
}
