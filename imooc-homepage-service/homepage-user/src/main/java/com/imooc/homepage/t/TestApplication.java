package com.imooc.homepage.t;

import com.imooc.homepage.org.mybatis.spring.TestImportBeanDefinitionRegistarar;
import com.imooc.homepage.t.service.TestService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 *
 * mybatis-spring 测试入口
 * @author JavaLi
 * @date 2021/1/24 18:08:58
 */

@ComponentScan("com.imooc.homepage.t")
@Import(TestImportBeanDefinitionRegistarar.class)
public class TestApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(TestApplication.class);
        applicationContext.refresh();

        TestService testService = applicationContext.getBean("testService",TestService.class);
        testService.test();


    }
}
