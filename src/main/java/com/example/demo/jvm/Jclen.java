package com.example.demo.jvm;

import com.example.demo.mall.domain.Student;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

public class Jclen {
    private  int a = 123;
    private  Student student;
    private  String b = "abc10感觉20";
    public static void main(String[] args) {
//        Object obj = generate();
        Jclen jc = new Jclen();

//        jc.add();
//        String e ="haha";
        //查看对象内部信息
//        System.out.println((ClassLayout.parseInstance(jc).toPrintable()));
        //查看对象内部信息
        System.out.println(ClassLayout.parseInstance(jc).toPrintable());

        //查看对象外部信息
        System.out.println(GraphLayout.parseInstance(jc).toPrintable());

        //获取对象总大小
        System.out.println("size : " + GraphLayout.parseInstance(jc).totalSize());



//        System.out.println(e);
    }
//    static Object generate() {
//        Map<String, Object> map = new HashMap<>();
//        map.put("a", new Integer(1));
//        map.put("b", "b");
//        map.put("c", new Date());
//
//        for (int i = 0; i < 10; i++) {
//            map.put(String.valueOf(i), String.valueOf(i));
//        }
//        return map;
//    }

//    int add(){
//        int d = 4;
//        int c = 3;
//        return d+c;
//    }


}
