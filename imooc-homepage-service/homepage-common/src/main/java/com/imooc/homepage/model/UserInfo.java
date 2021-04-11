package com.imooc.homepage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>用户基本信息</h1>
 * @author JavaLi
 * @date 2020/12/6 10:18:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

    private Long id;

    private String userName;

    private String email;

    public static UserInfo invalid(){
        return new UserInfo(-1L,"","");
    }
}
