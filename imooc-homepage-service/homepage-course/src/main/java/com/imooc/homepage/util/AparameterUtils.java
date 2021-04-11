package com.imooc.homepage.util;

import com.imooc.homepage.annotation.Aparameter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author lhw
 * @date 2021/4/3
 * <h2>自定义注解解析器 工具类</h2>
 */
public class AparameterUtils {

    public static void parameterAnnotation(Class clazz){
        
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            Annotation[][] annotations = method.getParameterAnnotations();
            for (Annotation[] annotation : annotations) {
                System.out.println(annotation);
            }
        }
       
    }
}
