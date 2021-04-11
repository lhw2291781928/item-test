package com.imooc.homepage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


/**
 * <h1>SpringBoot 启动入口</h1>
 * @author JavaLi
 * @date 2020/12/6 10:50:07
 */
@EnableJpaAuditing
@EnableEurekaClient
@SpringBootApplication
@Slf4j
public class HomePageCourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomePageCourseApplication.class,args);
        log.info("Course服务启动成功");
    }
}
