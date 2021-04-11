package com.imooc.homepage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <h1>课程信息请求对象定义</h1>
 * @author JavaLi
 * @date 2020/12/6 10:31:26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseInfoRequest {

    private List<Long> ids;
}
