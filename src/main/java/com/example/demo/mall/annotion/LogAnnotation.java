package com.example.demo.mall.annotion;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited()
public @interface LogAnnotation {
    String desc();
}
