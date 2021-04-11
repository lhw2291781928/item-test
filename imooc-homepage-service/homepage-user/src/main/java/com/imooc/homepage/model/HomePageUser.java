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
 * <h1>homepage_course 用户实体</h1>
 * @author JavaLi
 * @date 2020/12/24 20:39:06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class HomePageUser {

    /**
     * 主键
     * 配置为主键自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    /**
     * 用户名
     */
    @Basic
    @Column(name = "username",nullable = false)
    private String userName;

    /**
     * email
     */
    @Basic
    @Column(name = "email",nullable = false)
    private String email;

    /**
     * 创建时间
     */
    @Basic
    @Column(name = "create_time",nullable = false)
    @CreatedDate
    private Date createTime;

    /**
     * 更新时间
     */
    @Basic
    @Column(name = "update_time",nullable = false)
    @LastModifiedDate
    private Date updateTime;

    public HomePageUser(String useName,String email){
        this.userName = useName;
        this.email = email;
    }

    /**
     * <h2>返回一个无效的课程</h2>
     */
    public static HomePageUser invalid(){
        HomePageUser homePageUser = new HomePageUser("","");
        homePageUser.setId(-1L);
        return homePageUser;
    }

}
