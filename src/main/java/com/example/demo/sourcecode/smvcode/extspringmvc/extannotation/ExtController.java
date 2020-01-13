package com.example.demo.sourcecode.smvcode.extspringmvc.extannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义控制器注解
 *
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExtController {

}
