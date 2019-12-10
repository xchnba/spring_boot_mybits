package com.example.demo.mall.common.aop;

import com.example.demo.mall.annotion.LogAnnotation;
import com.github.pagehelper.PageHelper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
@Aspect //AOP 切面
@Component
public class CommonLogAspect {

    /*通过@Pointcut指定切入点 ，这里指定的切入点为LogAnnotation注解类型，也就是
      被@LogAnnotation注解修饰的方法，进入该切入点*/
    @Pointcut(value = "@annotation(com.example.demo.mall.annotion.LogAnnotation)")
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
    public Object around(ProceedingJoinPoint point, LogAnnotation logA) {

        System.out.println("执行了around方法");
        Object[] as = point.getArgs();
        for (int i=0;i<as.length;i++){
            String aa = as[i].toString();
            System.out.println("传入的详细入参aa=="+aa);
        }
        int page = (int) as[0];
        int size = (int) as[1];
        PageHelper.startPage(page,size);
        System.out.println("传入的入参是=="+as.toString());
        String msg = logA.desc();
        //拦截的类名
        Class clazz = point.getTarget().getClass();
        //拦截的方法
        Method method = ((MethodSignature) point.getSignature()).getMethod();

        System.out.println("执行了类:" + clazz + " 方法:" + method + " 自定义消息:" + msg);

        try {
            return point.proceed(); //执行程序
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return throwable.getMessage();
        }
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


}
