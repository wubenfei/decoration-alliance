package com.ours.entity;

import lombok.Data;

@Data
public class Wages {
    /**
    * 主键
    */
    private Integer id;

    /**
    * 工号
    */
    private String jobNumber;

    /**
    * 员工姓名
    */
    private String name;

    /**
    * 基本工资
    */
    private Integer wages;

    /**
    * 提成
    */
    private Integer royalty;

    /**
    * 员工状态
    */
    private String status;
}