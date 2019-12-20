package com.example.demo.mall.controller.thread.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class ProducerThread implements Runnable {
    private BlockingQueue<String> blockingQueue;
    private AtomicInteger count = new AtomicInteger();
    private volatile boolean flag = true;

    public ProducerThread(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "生产者开始启动");
        while (flag) {
            String data = count.incrementAndGet() + "";
            try {
                boolean offer = blockingQueue.offer(data,2, TimeUnit.SECONDS);
                if (offer){
                    System.out.println(Thread.currentThread().getName()+",生产队列"+data+"成功");
                }else {
                    System.out.println(Thread.currentThread().getName()+",生产队列"+data+"失败");
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+",生产队列线程停止");
    }
    public void stop(){
        this.flag = false;
    }
}

class ConsumerThread implements Runnable{
    private volatile boolean flag = true;
    private BlockingQueue<String> blockingQueue;
    public ConsumerThread(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "生产者开始启动");
        while (flag) {
            try {
                String data = blockingQueue.poll(2,TimeUnit.SECONDS);
                if(data == null){
                    flag = false;
                    System.out.println("消费者超过2秒没有获取到生产者消息");
                    return;
                }
                System.out.println("消费者获取消息称"+data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

public class BlockQueue {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<>(1);
        ProducerThread producerThread = new ProducerThread(blockingQueue);
        ConsumerThread consumerThread = new ConsumerThread(blockingQueue);
        Thread t1 = new Thread(producerThread);
        Thread t2 = new Thread(consumerThread);
        t1.start();
        t2.start();
        //10秒后停止线程
        try {
            Thread.sleep(1000*10);
            producerThread.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
