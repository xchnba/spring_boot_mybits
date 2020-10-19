package com.example.demo.jvm.classloader;

public class D extends C {
    public D(A a) {
        super(a);
    }

    @Override
    public void run() {
        System.out.println("执行D的方法");
        super.run();
    }
}
