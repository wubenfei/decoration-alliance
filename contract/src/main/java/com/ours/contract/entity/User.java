package com.ours.contract.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUseridTitle() {
        return useridTitle;
    }

    public void setUseridTitle(String useridTitle) {
        this.useridTitle = useridTitle;
    }

    private String useridTitle;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", url='" + url + '\'' +
                ", useridTitle='" + useridTitle + '\'' +
                '}';
    }
}