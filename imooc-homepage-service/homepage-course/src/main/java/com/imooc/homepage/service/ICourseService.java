package com.imooc.homepage.service;

import com.imooc.homepage.model.CourseInfo;
import com.imooc.homepage.model.CourseInfoRequest;

import java.util.List;

/**
 * <h1>课程相关服务接口定义</h1>
 * @author JavaLi
 * @date 2020/12/6 11:38:49
 */
public interface ICourseService {

    /**
     * <h2>通过id 获取课程信息</h2>
     */
    CourseInfo getCourseInfo(Long id);

    /**
     * <h2>通过ids 获取课程信息</h2>
     */
    List<CourseInfo> getCourseInfos(CourseInfoRequest request);


}
