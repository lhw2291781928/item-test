package com.imooc.homepage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author JavaLi
 * @description: 启动应用
 * @date 2020/11/22 10:53:28
 *
 * 1.使用 @EnableEurekaServer 注解让应用变为Eurkea Server
 * 2.Eurkea Server 的pom文件中添加  spring-cloud-starter-netflix-eureka-server 依赖，标识其为 eureka服务端
 */

@EnableEurekaServer
@SpringBootApplication
@Slf4j
public class EurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class,args);
        log.info("Eureka注册中心启动成功");
    }
}
