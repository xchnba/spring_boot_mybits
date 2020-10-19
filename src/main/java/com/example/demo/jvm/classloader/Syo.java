package com.example.demo.jvm.classloader;

public class Syo {
    public static void main(String[] args) {
        A a = new B();
        a = new  D(a);
        a = new E(a);
        a.run();
    }
}

