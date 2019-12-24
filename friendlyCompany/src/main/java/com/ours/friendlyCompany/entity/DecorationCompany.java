package com.ours.friendlyCompany.entity;

import java.util.Date;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanySynopsis() {
        return companySynopsis;
    }

    public void setCompanySynopsis(String companySynopsis) {
        this.companySynopsis = companySynopsis;
    }

    public Date getCompanyIntime() {
        return companyIntime;
    }

    public void setCompanyIntime(Date companyIntime) {
        this.companyIntime = companyIntime;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCompanyRephone() {
        return companyRephone;
    }

    public void setCompanyRephone(String companyRephone) {
        this.companyRephone = companyRephone;
    }

    public String getCompanyIdcard() {
        return companyIdcard;
    }

    public void setCompanyIdcard(String companyIdcard) {
        this.companyIdcard = companyIdcard;
    }

    public String getCompanyIdname() {
        return companyIdname;
    }

    public void setCompanyIdname(String companyIdname) {
        this.companyIdname = companyIdname;
    }

    public String getCompanyStatus() {
        return companyStatus;
    }

    public void setCompanyStatus(String companyStatus) {
        this.companyStatus = companyStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", password=").append(password);
        sb.append(", companyName=").append(companyName);
        sb.append(", companyAddress=").append(companyAddress);
        sb.append(", companySynopsis=").append(companySynopsis);
        sb.append(", companyIntime=").append(companyIntime);
        sb.append(", companyPhone=").append(companyPhone);
        sb.append(", companyRephone=").append(companyRephone);
        sb.append(", companyIdcard=").append(companyIdcard);
        sb.append(", companyIdname=").append(companyIdname);
        sb.append(", companyStatus=").append(companyStatus);
        sb.append("]");
        return sb.toString();
    }
}