package com.example.demo.mall.controller.thread.threadpool;

import java.util.Currency;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Queue001 {
    public static void main(String[] args) {
        //无限队列，队列先进先出
        ConcurrentLinkedDeque<String> linkedDeque = new ConcurrentLinkedDeque();
        linkedDeque.offer("张三");
        linkedDeque.offer("李四");
        linkedDeque.offer("王五");
        System.out.println(linkedDeque.size());
//        System.out.println(linkedDeque.poll());
//        System.out.println(linkedDeque.poll());
//        System.out.println(linkedDeque.poll());
        for (int i=0;i<linkedDeque.size();i++){
//            System.out.println(linkedDeque.poll());
            System.out.println(linkedDeque.peek());
        }

    }
}
