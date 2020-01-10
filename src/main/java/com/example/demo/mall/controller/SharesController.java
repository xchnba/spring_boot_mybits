package com.example.demo.mall.controller;

import com.example.demo.interview.TestCsv;
import com.example.demo.mall.common.Utils.IdUtils;
import com.example.demo.mall.controller.thread.threadpool.UsersCallable;
import com.example.demo.mall.dao.SharesDao;
import com.example.demo.mall.dao.UserDao;
import com.example.demo.mall.domain.Shares;
import com.example.demo.mall.domain.User;
import com.example.demo.mall.service.SharesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@Controller
public class SharesController {
    @Autowired
    SharesService sharesService;
    @Autowired
    SharesDao sharesDao;

    @RequestMapping("/queryshares")
    @ResponseBody
    public String queryshares(){

      List<Shares> sharesList = new ArrayList<>();
      List<Shares> jpList1 = new LinkedList<>();
      List<Shares> jpList2 = new LinkedList<>();
      List<Shares> shares = sharesService.getSharesBydate();
      for(int i=0;i<shares.size();){
          shares.get(i);
          sharesList.add(shares.get(i));
//          System.out.println(shares.get(i).toString());
          i=i+5;
      }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        dingtou(sharesList);
        for(int i=0;i<sharesList.size();i++){
            int n = i + 1;
            if(n>87){
                jpList1.add(sharesList.get(i));
            }
        }

//        dingtou(jpList1);
        for(int i=0;i<jpList1.size();i++){
            int n = i + 1;
            if(n>279){
                jpList2.add(jpList1.get(i));
            }
        }
//        dingtou(jpList2);
        return "查询成功";
    }

    private void dingtou(List<Shares> jpList1) {
        double kpj = 100.00;
        double dt = 1000l;  //定投金额
        double fe = 0;    //份额
        double ljfe = 0; //累计份额
        double jj = 0; //均价
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(int i=0;i<jpList1.size();i++){
            int n = i + 1;
            kpj = jpList1.get(i).getKpj();
            fe = dt/kpj;
            ljfe = fe +ljfe;
            jj = (i+1)*dt/ljfe;
            if(n>52){
                if(kpj>jj*(1+n*0.0025)){
                    System.out.println("定投到第"+(i+1)+"周"+sdf.format(jpList1.get(i).getGpdate())+"净利润=="+(ljfe*jpList1.get(i).getPjj()-n*dt));
                    break;
                }
            }
            System.out.println("定投到第"+(i+1)+"周"+sdf.format(jpList1.get(i).getGpdate())+"均价等于=="+jj+"累计份额=="+ljfe+"当日均价"+jpList1.get(i).getPjj());
            System.out.println(jpList1.get(i).toString());
        }
    }


}

