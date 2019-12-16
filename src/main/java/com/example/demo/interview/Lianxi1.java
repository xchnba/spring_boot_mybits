package com.example.demo.interview;

import com.example.demo.mall.domain.User;
import org.springframework.transaction.jta.WebSphereUowTransactionManager;
import sun.java2d.pipe.AAShapePipe;

import java.util.*;

public class Lianxi1 {

    public static void main(String[] args) {
//        String a = "a1bc2def3";
        //求输出结果为abcbcdefdefdef
//        String b = covenString(a);
        List<String> iter = new ArrayList<>();
        iter.add("aa");
        iter.add("bb");
        iter.add("cc");
        List<String> iters = new ArrayList<>();
        iters.add("bb");
        iters.add("cc");
        iters.add("dd");
        Map<String,Object> map = new HashMap<>();
        for (String it:iter){
            if(!map.containsKey(it)){
                map.put(it,"abc");
            }
        }
        for (String it:iters){
            if(!map.containsKey(it)){
                map.put(it,"abc");
            }
        }
        map.remove("aa");
        Iterator keys = map.keySet().iterator();
        while(keys.hasNext()){
            String key = (String)keys.next();
                System.out.println("存在key集合==="+key);
            }
        List<User> userList = new ArrayList<>();



    }

    private static String covenString(String a) {
        StringBuffer sb = new StringBuffer();
        StringBuffer temp = new StringBuffer();
        for (char b:a.toCharArray()){
            if(Character.isDigit(b)){
                int number = Integer.parseInt(String.valueOf(b));
                for(int i=0;i<number;i++){
                    sb.append(temp);
                }
                temp.setLength(0);
            }else {
                temp.append(b);
            }

        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
