package com.example.demo.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * iframe 控制器研究iframe的多层嵌套取值问题
 *
 */
@Controller
@RequestMapping("iframe")
public class IframeController {
    @RequestMapping("iframe")
    public String iframe(){
          String abc="23344";
        return "/iframe/iframe1";
    }
}
