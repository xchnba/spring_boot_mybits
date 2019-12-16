package com.example.demo.mall.controller;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

@Controller
public class FileUploadController {
    /**
     * 从流中获取一个上传文件
     * @param request
     * @return
     */
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


    /**
     * 从流中获多个上传文件
     * @param request
     * @return
     */
    @RequestMapping("/uploadmuti")
    public String uploadmuti(HttpServletRequest request){
        //多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //判断是否是多数据段提交格式
        if(multipartResolver.isMultipart(request)){
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            Iterator<String> iter = multiRequest.getFileNames();
            Integer fileCont = 0;
            while (iter.hasNext()){
                MultipartFile multipartFile = multiRequest.getFile(iter.next());
                String fileName = multipartFile.getOriginalFilename();
                fileCont ++;
                System.out.println("获取的文件名称和文件流====="+fileName+"文件数量=="+fileCont);
            }
        }

        String a="nihaoa";
        return "/test/look";
    }


}
