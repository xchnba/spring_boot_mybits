package com.example.demo.mall.controller.thread;

class Res {
//    public Integer count = 0;
    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
             return 0;
        }
    };
    public Integer getNumber(){
        int count = threadLocal.get()+1;
        threadLocal.set(count);
        return count;
//        return  ++count;
    }
}

public class Thread007 extends Thread {
   private Res res;
   public Thread007(Res res){
           this.res = res;
    }

    @Override
    public void run() {
        for (int i=0;i<3;i++){
            System.out.println(Thread.currentThread().getName()+","+res.getNumber());
        }
    }

    public static void main(String[] args) {
        Res res = new Res();
        Thread007 t1 = new Thread007(res);
        Thread007 t2 = new Thread007(res);
        t1.start();
        t2.start();
    }
}
