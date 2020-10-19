package com.example.demo.jvm.classloader;

public class E extends C {
    public E(A a) {
        super(a);
    }

    @Override
    public void run() {

        super.run();
        System.out.println("执行E的方法");

    }
}
