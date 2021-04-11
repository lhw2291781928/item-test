package com.imooc.homepage.t.service;

import com.imooc.homepage.t.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author JavaLi
 * @date 2021/1/24 18:08:37
 */

@Component
public class TestService {

    @Autowired
    public UserMapper userMapper;

    public void test(){
        System.out.println(userMapper.test());
    }
}
