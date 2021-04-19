package com.imooc.homepage.controller;

import com.alibaba.fastjson.JSON;
import com.imooc.homepage.model.CourseInfo;
import com.imooc.homepage.model.CourseInfoRequest;
import com.imooc.homepage.service.ICourseService;
import com.imooc.homepage.util.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <h1>课程服务 控制层</h1>
 * @author JavaLi
 * @date 2020/12/6 12:14:03
 */
@Slf4j
@RestController
public class HomePageCourseController {

    /**
     * 课程服务实现 接口
     */
    private final ICourseService courseService;
    private final RedisUtils redisUtils;


    public HomePageCourseController(ICourseService courseService,RedisUtils redisUtils) {
        this.courseService = courseService;
        this.redisUtils = redisUtils;
    }

    @GetMapping("course")
    public CourseInfo getCourseInfo(Long id){
        log.info("<homepage-course>: get course -> {}",id);
        System.out.println(courseService.getCourseInfo(id));
        CourseInfo courseInfo = (CourseInfo) redisUtils.get("cour" + id);
        return courseInfo == null? courseService.getCourseInfo(id):courseInfo;
    }

    @PostMapping("courses")
    public List<CourseInfo> getCourseInfos(@RequestBody  CourseInfoRequest request){
        log.info("<homepage-course: get courses ->{}", JSON.toJSONString(request));
        System.out.println(courseService.getCourseInfos(request));
        return courseService.getCourseInfos(request);
    }
}
