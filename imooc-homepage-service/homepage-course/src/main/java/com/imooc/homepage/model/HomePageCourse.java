package com.imooc.homepage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * <h1>homepage_course 映射实体表定义</h1>
 * @author Administrator
 * @author JavaLi
 * @date 2020/12/6 11:08:16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

/**
 * 监听数据变化，例如记录插入、更新数据的时间
 */
@EntityListeners(AuditingEntityListener.class)
@Table(name="homepage_course")
public class HomePageCourse {


    /**
     * 主键
     * GeneratedValue 配置主键增长方式为主键自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    /**
     * 课程名称
     * Basic 作用于方法或变量上 有属性可选为懒加载，默认为即时加载
     */
    @Basic
    @Column(name = "course_name",nullable = false)
    private String courseName;

    /**
     * 课程类型
     */
    @Basic
    @Column(name = "course_type",nullable = false)
    private Integer courseType;

    /**
     * 课程图标
     */
    @Basic
    @Column(name = "course_icon",nullable = false)
    private String courseIcon;

    /**
     * 课程介绍
     */
    @Basic
    @Column(name = "course_intro",nullable = false)
    private String courseIntro;

    /**
     * 创建时间
     * CreatedDate  JPA注解  配合EntityListeners使用,JPA自动帮我们生成创建时间
     */
    @Basic
    @Column(name = "create_time",nullable = false)
    @CreatedDate
    private Date createTime;

    /**
     * 更新时间   LastModifiedDate  JPA帮我们自动记录更新时间
     */
    @Basic
    @Column(name = "update_time",nullable = false)
    @LastModifiedDate
    private Date updateTime;

    public HomePageCourse(String courseName,Integer courseType,
                          String courseIcon,String courseIntro){
        this.courseName = courseName;
        this.courseType = courseType;
        this.courseIcon = courseIcon;
        this.courseIntro = courseIntro;
    }

    /**
     * <h2>返回一个无效的课程</h2>
     */
    public static HomePageCourse invalid(){
        HomePageCourse homePageCourse = new HomePageCourse("",0,"","");
        homePageCourse.setId(-1L);
        return homePageCourse;
    }
}
