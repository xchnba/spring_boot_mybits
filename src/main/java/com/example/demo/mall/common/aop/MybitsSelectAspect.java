package com.example.demo.mall.common.aop;

import com.example.demo.common.utils.SQLUtils;
import com.example.demo.mall.annotion.LogAnnotation;
import com.example.demo.mall.annotion.MytbitsSelect;
import com.example.demo.sourcecode.mybitsorm.orm.annotation.ExtInsert;
import com.example.demo.sourcecode.mybitsorm.orm.annotation.ExtParam;
import com.example.demo.sourcecode.mybitsorm.orm.annotation.ExtSelect;
import com.example.demo.sourcecode.mybitsorm.orm.utils.JDBCUtils;
import com.github.pagehelper.PageHelper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Aspect //AOP 切面
@Component
public class MybitsSelectAspect {

    /*通过@Pointcut指定切入点 ，这里指定的切入点为LogAnnotation注解类型，也就是
      被@LogAnnotation注解修饰的方法，进入该切入点*/
    @Pointcut(value = "@annotation(com.example.demo.mall.annotion.MytbitsSelect)")
    private void pointcut() {

    }

    /**
     * 在方法执行前后
     *
     * @param point
     * @param logA
     * @return
     */
    @Around(value = "pointcut() && @annotation(logA)")
    public Object around(ProceedingJoinPoint point, MytbitsSelect logA) throws Throwable {

        System.out.println("执行了around方法");
        Object[] args = point.getArgs();
//        for (int i=0;i<as.length;i++){
//            String aa = as[i].toString();
//            System.out.println("传入的详细入参aa=="+aa);
//        }
//        int page = (int) as[0];
//        int size = (int) as[1];
//        PageHelper.startPage(page,size);
//        System.out.println("传入的入参是=="+as.toString());
        String msg = logA.desc();
        //拦截的类名
        Class clazz = point.getTarget().getClass();
        //拦截的方法
        Method method = ((MethodSignature) point.getSignature()).getMethod();

        System.out.println("使用动态代理技术拦截接口方法开始");
        // 使用白话问翻译,@ExtInsert封装过程
        // 1. 判断方法上是否存在@ExtInsert
        ExtInsert extInsert = method.getDeclaredAnnotation(ExtInsert.class);

        // 2.查询的思路
        // 1. 判断方法上是否存 在注解
        ExtSelect extSelect = method.getDeclaredAnnotation(ExtSelect.class);
        Object proxy = null;
        if (extSelect != null) {
            // 2. 获取注解上查询的SQL语句
            String selectSQL = extSelect.value();
            // 3. 获取方法上的参数,绑定在一起
            ConcurrentHashMap<Object, Object> paramsMap = paramsMap(proxy, method, args);
            // 4. 参数替换？传递方式
            List<String> sqlSelectParameter = SQLUtils.sqlSelectParameter(selectSQL);
            // 5.传递参数
            List<Object> sqlParams = new ArrayList<>();
            for (String parameterName : sqlSelectParameter) {
                Object parameterValue = paramsMap.get(parameterName);
                sqlParams.add(parameterValue);
            }
            // 6.将sql语句替换成?
            String newSql = SQLUtils.parameQuestion(selectSQL, sqlSelectParameter);
            System.out.println("newSQL:" + newSql + ",sqlParams:" + sqlParams.toString());

            // 5.调用jdbc代码底层执行sql语句
            // 6.使用反射机制实例对象### 获取方法返回的类型，进行实例化
            // 思路:
            // 1.使用反射机制获取方法的类型
            // 2.判断是否有结果集,如果有结果集，在进行初始化
            // 3.使用反射机制,给对象赋值

            ResultSet res = JDBCUtils.query(newSql, sqlParams);
            // 判断是否存在值
            if (!res.next()) {
                return null;
            }
            // 下标往上移动移位
            res.previous();
            // 使用反射机制获取方法的类型
            Class<?> returnType = method.getReturnType();
            Object object = returnType.newInstance();
            while (res.next()) {
                // 获取当前所有的属性
                Field[] declaredFields = returnType.getDeclaredFields();
                for (Field field : declaredFields) {
                    String fieldName = field.getName();
                    Object fieldValue = res.getObject(fieldName);
                    field.setAccessible(true);
                    field.set(object, fieldValue);
                }
                // for (String parameteName : sqlSelectParameter) {
                // // 获取参数值
                // Object resultValue = res.getObject(parameteName);
                // // 使用java的反射值赋值
                // Field field = returnType.getDeclaredField(parameteName);
                // // 私有方法允许访问
                // field.setAccessible(true);
                // field.set(object, resultValue);
                // }
            }
            return object;
        }
        return null;
    }

    /**
     * 方法执行后
     *
     * @param joinPoint
     * @param logA
     * @param result
     * @return
     */
    @AfterReturning(value = "pointcut() && @annotation(logA)", returning = "result")
    public Object afterReturning(JoinPoint joinPoint, LogAnnotation logA, Object result) {
        System.out.println("执行了afterReturning方法: result=" + result);
        return result;
    }

    /**
     * 方法执行后 并抛出异常
     *
     * @param joinPoint
     * @param logAnnotation
     * @param ex
     */
    @AfterThrowing(value = "pointcut() && @annotation(logAnnotation)", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, LogAnnotation logAnnotation, Exception ex) {
        System.out.println("执行了afterThrowing方法");
        System.out.println("请求：" + logAnnotation.desc() + " 出现异常");
    }

    private ConcurrentHashMap<Object, Object> paramsMap(Object proxy, Method method, Object[] args) {
        ConcurrentHashMap<Object, Object> paramsMap = new ConcurrentHashMap<>();
        // 获取方法上的参数
        Parameter[] parameters = method.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            ExtParam extParam = parameter.getDeclaredAnnotation(ExtParam.class);
            if (extParam != null) {
                // 参数名称
                String paramName = extParam.value();
                Object paramValue = args[i];
                // System.out.println(paramName + "," + paramValue);
                paramsMap.put(paramName, paramValue);
            }
        }
        return paramsMap;
    }



}
