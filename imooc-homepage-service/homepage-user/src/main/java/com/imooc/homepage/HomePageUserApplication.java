package com.imooc.homepage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 *
 * <h1>用户服务模块 启动类</h1>
 * @author JavaLi
 * @date 2020/12/24 20:27:25
 */

@EnableJpaAuditing
@EnableFeignClients
@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
public class HomePageUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(HomePageUserApplication.class,args);
    }
}
