package com.ours.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 员工头像
     */
    private String url;

    /**
     * 员工工号
     */
    private String jobNumber;

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

    /**
     * 员工职级
     */
    private String roleName;

    /**
     * 手机号码
     */
    private String tel;

    /**
     * 家庭住址
     */
    private String addr;

    /**
     * 身份证号码
     */
    private String idCard;

    /**
     * 入职时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date joinDate;

    /**
     * 离职时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date dismissionDate;
}