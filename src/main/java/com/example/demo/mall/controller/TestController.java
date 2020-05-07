package com.example.demo.mall.controller;



import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/look")
    public String look(){
        return "/test/look";
    }

    @RequestMapping("/menu")
    public String menu(){
        return "/test/menu";
    }

    @RequestMapping("/upload")
    public String upload(HttpServletRequest request){
        MultipartFile file = null;
        String name="haha";
        InputStream inputStream=null;
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart){
         MultipartHttpServletRequest multipartRequest = WebUtils.getNativeRequest(request, MultipartHttpServletRequest.class);
         file = multipartRequest.getFile("file");
          name = file.getOriginalFilename();
            try {
                inputStream =  file.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String a="nihaoa";
        System.out.println(name);
        return "/test/look";
    }


    @RequestMapping("/addcss")
    public String addcss(HttpServletRequest request){
        return "/page/jskzcss";
    }

    @RequestMapping("/select")
    public String select(){
        String a = "2122323";
        return "/test/selectPage";
    }
    @RequestMapping("/showPdf")
    public String showPdf(){
        String a = "2122323";
        return "/test/showPdf";
    }

}
