package com.example.demo.jvm.classloader;

public abstract class C extends A  {
    private A a;
    public  C(A a){
        this.a = a;
    }
    @Override
    public void run() {
        if(a != null){
            a.run();
        }
    }
}
