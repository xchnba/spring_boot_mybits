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
      List<Shares> sharesList = new LinkedList<>();
      List<Shares> shares = sharesService.getSharesBydate();
      for(int i=0;i<shares.size();){
          shares.get(i);
          sharesList.add(shares.get(i));
//          System.out.println(shares.get(i).toString());
          i=i+5;
      }
        double kpj = 100.00;
        double jj = 0;
        for(int i=0;i<sharesList.size();i++){
            kpj = sharesList.get(i).getKpj();
            if(i == 0){
                jj = kpj;
            }
            jj =  (jj + kpj)/(i+1);
            System.out.println(sharesList.get(i).toString());
        }
        return "查询成功";
    }


}

