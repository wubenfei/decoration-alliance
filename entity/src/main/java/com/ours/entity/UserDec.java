package com.ours.entity;

import lombok.Data;

@Data
public class UserDec {
    private Integer id;

    private Integer userId;

    /**
    * 装修团队
    */
    private Integer decId;

    /**
    * 客户状态:0-合作崩了,1-合作中,2-合作结束
    */
    private Integer userStatus;

    /**
    * 设计师状态:0-合作崩了,1-合作中,2-合作结束
    */
    private Integer desStatus;

    /**
    * 是否:1-显示,0-不显示
    */
    private Integer in;
}