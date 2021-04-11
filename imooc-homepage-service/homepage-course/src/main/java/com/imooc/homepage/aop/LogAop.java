package com.imooc.homepage.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author lhw
 * @date 2021/4/3
 * 自定义Log注解的 注解解析器
 */
@Component
@Aspect
public class LogAop {


    @Pointcut("@annotation(com.imooc.homepage.annotation.Log)")
    public void logService(){
        //这个方法不会生效，切点只能在切点前后生效，不能在切点中生效
        System.out.println("这是记录日志服务");
    }

    @Before("logService()")
    public void beforeLog(){
        System.out.println("这是记录日志前的操作");
    }

    @After("logService()")
    public void afterLog(){
        System.out.println("这是记录日志后的操作");
    }
}
