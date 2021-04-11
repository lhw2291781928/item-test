package com.imooc.homepage.annotation;

import java.lang.annotation.*;

/**
 * @author lhw
 * @date 2021/4/3
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER,ElementType.TYPE})
@Documented
public @interface Aparameter {
}
