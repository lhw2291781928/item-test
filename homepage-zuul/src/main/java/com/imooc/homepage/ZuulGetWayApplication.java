package com.imooc.homepage;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author JavaLi
 * @description: SpringCloud 网关
 * @date 2020/11/22 15:44:38
 */

@EnableZuulProxy
@SpringCloudApplication
public class ZuulGetWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulGetWayApplication.class,args);
    }
}
