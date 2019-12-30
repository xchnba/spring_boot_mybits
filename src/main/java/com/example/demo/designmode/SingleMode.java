package com.example.demo.designmode;

//使用枚举方法创建单例
public class SingleMode {
    private SingleMode (){}
    public static SingleMode getInstance(){
        return SingletoEnum.INSTANCE.getSingleMode();
    }
    //枚举本身就是单例的
    static enum SingletoEnum{
        INSTANCE;
        private  SingleMode singleMode ;
        private SingletoEnum(){
            singleMode = new SingleMode();
        }
        public SingleMode getSingleMode(){
            return  this.singleMode;
        }
    }

    public static void main(String[] args) {
        SingleMode s1 = SingleMode.getInstance();
        SingleMode s2 = SingleMode.getInstance();
        System.out.println(s1 == s2);
    }
}


// 饿汉模式
class SingleMode01{
    //单例的思想就是让对象只能创建一次
    //实现方法就是构造方法私有化new对象 然后提供对外的公有方法
    private  static SingleMode01 singleMode01 = new SingleMode01();

    private SingleMode01(){

    }

    public static SingleMode01 getSingleMode01() {
        return singleMode01;
    }
}
// 懒汉模式
class SingleMode02{
    //单例的思想就是让对象只能创建一次
    //实现方法就是构造方法私有化new对象 然后提供对外的公有方法
    //类初始化时，不会初始化该对象，真正需要使用的时候才会创建该对象。
    private  static SingleMode02 singleMode02 ;

    private SingleMode02(){

    }
   //需要加锁效率低
    public synchronized static SingleMode02 getSingleMode02() {
        if(singleMode02 == null){
            singleMode02 = new SingleMode02();
        }
        return singleMode02;
    }
}

// 静态内部类方式
 class SingleMode03 {
    private SingleMode03() {
        System.out.println("初始化..");
    }

    public static class SingletonClassInstance {
        private static final SingleMode03 singletonDemo03 = new SingleMode03();
    }

    // 方法没有同步
    public static SingleMode03 getInstance() {
        System.out.println("getInstance");
        return SingletonClassInstance.singletonDemo03;
    }


}