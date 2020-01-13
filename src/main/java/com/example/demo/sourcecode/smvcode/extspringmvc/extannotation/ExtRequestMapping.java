package com.example.demo.sourcecode.smvcode.extspringmvc.extannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义RequestMapping 作者: 每特教育-余胜军<br>
 * 联系方式:QQ644064779|WWW.itmayiedu.com<br>
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExtRequestMapping {
	String value() default "";
}
