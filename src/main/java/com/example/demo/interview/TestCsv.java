package com.example.demo.interview;

import com.example.demo.mall.common.Utils.IdUtils;
import com.example.demo.mall.dao.SharesDao;
import com.example.demo.mall.domain.Shares;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;


/**
 * @author uiao
 * @Title: TestCsv
 * @date 2018/8/717:00
 */
public class TestCsv {

   private SharesDao sharesDao;

    public static void main(String[] args) {

        double dt = 10000l; //  定投1万2每个月
        double pj = dt/5762;
        double lv = 0.012; //利率百分之1.2，年化利率百分之14.4
        double lj = 0;
        for (int i = 0;i<12;i++){
            lj = (lj+dt)*1.012;
            System.out.println("第"+i+"个月后累计为多少=="+lj);
        }
        System.out.println("60个月后累计为多少=="+lj);
        System.out.println("均价等于"+pj);
//        TestCsv test = new TestCsv();
//        test.test(3, 1);
    }

    public  TestCsv(SharesDao sharesDao){
        this.sharesDao = sharesDao;
    }

    public void test(int row, int col) {
        try {
            //先FileReader把文件读出来再bufferReader按行读  reader.readLine(); 没有标题用不着了
            BufferedReader reader = new BufferedReader(new FileReader("E:\\data\\000300.csv"));
            String line = null;
            int index = 0;
            int number = 0;
            double spj =4328.22;
            double zgj =4528.22;
            double zdj =4352.22;
            double kpj =4325.22;
            double qspj =4329.22;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            while ((line = reader.readLine()) != null) {
                String item[] = line.split(",");//一行数组
                if (index >0 && index<4360) {// 第一行数据不读取
                    Shares shares = new Shares();
                    shares.setId(IdUtils.getRandomIdByUUID());
                    for (int i=0;i<item.length;i++){
                        String last = item[i];//这里
                        if(i==0){
                          Date dt = sdf.parse(last);
                          shares.setGpdate(dt);
                        }
                        if(i==1){
                            shares.setGpdm(last);
                        }
                        if(i==2){
                            shares.setName("沪深300");
                        }
                        if(i==3){
                            spj = Double.valueOf(last);
                            shares.setSpj(spj);
                        }
                        if(i==4){
                            zgj = Double.valueOf(last);
                            shares.setZgj(zgj);
                        }
                        if(i==5){
                            zdj = Double.valueOf(last);
                            shares.setZdj(zdj);
                        }
                        if(i==6){
                            kpj = Double.valueOf(last);
                            shares.setKpj(kpj);
                        }
                        if(i==7){
                            qspj = Double.valueOf(last);
                            shares.setQspj(qspj);
                        }
                        if(i==8){
                            shares.setZde(last);
                        }
                        if(i==9){
                            double pjj =(shares.getZgj()+shares.getZdj())/2;
                            shares.setZdf(last);
                            shares.setPjj(pjj);
                            sharesDao.save(shares);
                        }
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

