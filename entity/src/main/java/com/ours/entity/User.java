package com.ours.entity;

import lombok.Data;

@Data
public class User {
    /**
    * 角色id
    */
    private Integer id;

    /**
    * 用户名
    */
    private String username;

    /**
    * 电话
    */
    private String phone;

    /**
    * 邮箱
    */
    private String email;

    /**
    * 密码
    */
    private String password;

    /**
    * '状态:正常,锁定,注销'
    */
    private String status;

    /**
    * 头像地址
    */
    private String url;

    private String useridTitle;

    public User(String username, String phone, String password, String status, String useridTitle) {
        this.username = username;
        this.phone = phone;
        this.password = password;
        this.status = status;
        this.useridTitle = useridTitle;
    }

    public User() {
    }
}