package com.ours.entity;

import java.util.Date;
import lombok.Data;

@Data
public class Designer {
    /**
    * 角色id
    */
    private Integer id;

    /**
    * 头像地址
    */
    private String url;

    /**
    * 设计师工号
    */
    private String designerJob;

    /**
    * 工资
    */
    private String wages;

    /**
    * 设计师名
    */
    private String designerName;

    /**
    * 设计师电话
    */
    private String designerPhone;

    /**
    * 设计师邮箱
    */
    private String designerEmail;

    /**
    * 设计师密码
    */
    private String designerPassword;

    /**
    * '状态:正常,锁定,注销'
    */
    private String designerStatus;

    /**
    * 角色id
    */
    private Integer roleId;

    /**
    * 设计师职级
    */
    private String roleName;

    /**
    * 紧急手机号码
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
    private Date joinData;

    /**
    * 离职时间
    */
    private Date dismissionDate;

    private String designeridTitle;
}