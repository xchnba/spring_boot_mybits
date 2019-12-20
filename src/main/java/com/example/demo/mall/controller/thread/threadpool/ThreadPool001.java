package com.example.demo.mall.controller.thread.threadpool;


import java.util.concurrent.*;

public class ThreadPool001 {
    //常用的4种线程池和自定义线程池
    //1.无界限JVM自动回收可缓存线程池
    ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
    //2.定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
    ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
    //3.创建一个定长线程池，支持定时及周期性任务执行。
    ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(5);
    //4.创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
    ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
    public void zx(){
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            newScheduledThreadPool.schedule(new Runnable() {
                public void run() {
                    System.out.println("i:" + temp);
                }
            }, 3, TimeUnit.SECONDS);
          }
        }

    public static void main(String[] args) {
        //5.自定义线程池，参数分别是核心线程数，最大线程数，存活时间，和队列类型长度
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3));
        for (int i = 1; i <= 6; i++) {
            TaskThred t1 = new TaskThred("任务" + i);
            executor.execute(t1);
        }
        executor.shutdown();

    }

}

class TaskThred implements Runnable {
    private String taskName;

    public TaskThred(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+taskName);
    }

}
