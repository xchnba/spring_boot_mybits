package com.example.demo.interview;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


/**
 * @author uiao
 * @Title: TestCsv
 * @date 2018/8/717:00
 */
public class TestCsv {
    public static void main(String[] args) {
        TestCsv test = new TestCsv();
        test.test(3, 1);
    }

    public void test(int row, int col) {
        try {
            //先FileReader把文件读出来再bufferReader按行读  reader.readLine(); 没有标题用不着了
            BufferedReader reader = new BufferedReader(new FileReader("E:\\data\\000300.csv"));
            String line = null;
            int index = 0;
            int number = 0;
            while ((line = reader.readLine()) != null) {
                String item[] = line.split(",");//一行数组
                if (index >0 ) {// 第一行数据不读取
                    for (int i=0;i<item.length;i++){
                        String last = item[i];//这里
                        System.out.println(last+"一共打印了多少数据=="+number);
                        number++;
                    }
                }
                index++;
            }
        } catch (Exception e) {
            //在命令行打印异常信息在程序中出错的位置及原因。
            e.printStackTrace();
        }
    }
}

