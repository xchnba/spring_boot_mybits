package com.example.demo.jvm.classloader;

import java.io.InputStream;

public class MyClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            // 文件名称
            String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
            // 获取文件输入流
            InputStream is = this.getClass().getResourceAsStream(fileName);
            // 读取字节
            byte[] b = new byte[is.available()];
            is.read(b);
            // 将byte字节流解析成jvm能够识别的Class对象
            return defineClass(name, b, 0, b.length);
        } catch (Exception e) {
            throw new ClassNotFoundException();
        }

    }

}

