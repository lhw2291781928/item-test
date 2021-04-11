package com.imooc.homepage.service.impl;

import com.imooc.homepage.dao.HomePageCourseDao;
import com.imooc.homepage.model.CourseInfo;
import com.imooc.homepage.model.CourseInfoRequest;
import com.imooc.homepage.model.HomePageCourse;
import com.imooc.homepage.service.ICourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * <h1>课程服务功能 实现类</h1>
 * @author JavaLi
 * @date 2020/12/6 11:43:49
 */

@Slf4j
@Service
public class CourseServiceImpl implements ICourseService {

    private final HomePageCourseDao homePageCourseDao;

    /**
     * <h2>通过构造方法的方式 注入对象</h2>
     *
     */
    @Autowired
    public CourseServiceImpl(HomePageCourseDao homePageCourseDao) {
        this.homePageCourseDao = homePageCourseDao;
    }



    @Override
    public CourseInfo getCourseInfo(Long id) {
        Optional<HomePageCourse> course = homePageCourseDao.findById(id);

        return buildCourseInfo(course.orElse(HomePageCourse.invalid()));
    }


    @Transactional
    @Override
    public List<CourseInfo> getCourseInfos(CourseInfoRequest request) {
        if(CollectionUtils.isEmpty(request.getIds())){
            return Collections.emptyList();
        }
        List<HomePageCourse> courseList = homePageCourseDao.findAllById(request.getIds());

        return courseList.stream()
               .map(this::buildCourseInfo)
               .collect(Collectors.toList());
    }




    /**
     * <h2>根据数据记录构造对象信息</h2>
     * 此方法用于从entity到vo的转换
     */
    private CourseInfo buildCourseInfo(HomePageCourse course){

        return CourseInfo.builder()
                .id(course.getId())
                .courseName(course.getCourseName())
                .courseType(course.getCourseType() == 0? "免费课程":"实战课程")
                .courseIcon(course.getCourseIcon())
                .courseIntro(course.getCourseIntro())
                .build();
    }

}
