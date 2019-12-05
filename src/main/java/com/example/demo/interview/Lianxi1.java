package com.example.demo.interview;

import org.springframework.transaction.jta.WebSphereUowTransactionManager;

public class Lianxi1 {

    public static void main(String[] args) {
        String a = "a1bc2def3";
        //求输出结果为abcbcdefdefdef
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
    }
}
