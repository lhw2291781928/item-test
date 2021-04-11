package com.imooc.homepage.t.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * @author JavaLi
 * @date 2021/1/24 18:08:12
 */


public interface UserMapper {

    @Select("select 'TEST666'")
    String test();


}
