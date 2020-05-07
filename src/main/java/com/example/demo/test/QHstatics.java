package com.example.demo.test;

import com.sun.xml.internal.messaging.saaj.packaging.mime.Header;


import javax.print.DocFlavor;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.Set;


public class QHstatics {
    public static void main(String[] args) throws IOException {
//        gettatic();

        Set<String> stringSet = new HashSet<>();
        String a = "abc";
        String b = "der";
        stringSet.add(a);
        stringSet.add(b);
        stringSet.add("abc");
        System.out.println("是否存在==="+stringSet.contains("abc"));
        System.out.println(stringSet.size());
        for (String ba:stringSet ){
            System.out.println("遍历集合==="+ba);
        }




        URL url = new URL("http://www.tingshucloud.com/wp-content/uploads/2020/02/全球高武0439.mp3");
        URLConnection con = null;
        try{
            con = url.openConnection();
        }catch(IOException e){
            e.printStackTrace();
        }

        BufferedInputStream bis = new BufferedInputStream(con.getInputStream());

        String name ="全球高武";

        System.out.println("获取了io流");




    }

    private static void gettatic() {
        double bj = 5000;
        for (int i=0;i<100;i++){
            double cz = bj*0.4;
            double sy = bj-bj*0.4;
//            if(i%3 == 0){
//                cz=cz*0.85;
//            }else {
//                cz=cz*1.10;
//            }
            cz=cz*1.10;
            bj = cz+sy;
            System.out.println("止损第"+i+"次剩下的本金========"+bj);
        }
    }
}
