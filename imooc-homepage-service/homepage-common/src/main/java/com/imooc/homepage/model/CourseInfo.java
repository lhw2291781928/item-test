package com.imooc.homepage.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>课程信息</h1>
 * @author JavaLi
 * @date 2020/12/6 10:21:59
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseInfo {


    private Long id;

    private String courseName;

    private String courseType;

    private String courseIcon;

    private String courseIntro;

    public static CourseInfo invalid(){
        return new CourseInfo(-1L,"","","","");
    }

}
