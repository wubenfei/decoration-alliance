package com.ours.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecorationCompany {
    /**
     * 装修商id
     */
    private Integer id;

    /**
     * 密码
     */
    private String password;

    /**
     * 装修公司名字
     */
    private String companyName;

    /**
     * 装修公司地址
     */
    private String companyAddress;

    /**
     * 装修商简介
     */
    private String companySynopsis;

    /**
     * 装修公司入驻时间
     */
    private Date companyIntime;

    /**
     * 装修公司电话
     */
    private String companyPhone;

    /**
     * 装修公司备用电话
     */
    private String companyRephone;

    /**
     * 装修公司责任人身份证号
     */
    private String companyIdcard;

    /**
     * 装修公司责任人姓名
     */
    private String companyIdname;

    /**
     * 合作状态:合作中,合作解除
     */
    private String companyStatus;

    /**
     * 装修团队资质路径
     */
    private String companyUrl;
}