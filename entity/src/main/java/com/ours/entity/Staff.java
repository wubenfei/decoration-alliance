package com.ours.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 员工头像
     */
    private String url;

    /**
     * 工资
     */
    private String wages;

    /**
     * 员工姓名
     */
    private String staffName;

    /**
     * 员工电话
     */
    private String phone;

    /**
     * 员工登录密码
     */
    private String password;

    /**
     * 员工状态
     */
    private String status;

    /**
     * 角色id
     */
    private Integer roleId;
}