package com.imooc.homepage.annotation;

import java.lang.annotation.*;


/**
 * @author lhw
 * @date 2021/4/3
 * 自定义日志注解，用于记录加了该注解的方法执行日志
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface Log {
}
