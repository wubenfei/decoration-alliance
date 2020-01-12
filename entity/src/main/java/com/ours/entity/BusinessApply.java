package com.ours.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class BusinessApply {
    /**
    * 主键id
    */
    private Integer id;

    /**
    * 申请标题
    */
    private String applyTitle;

    /**
    * 业务申请的类型:合同审批，经费申请，工作计划审批...
    */
    private String applyType;

    /**
    * 申请编号:ZSLM20190101001
    */
    private String applyNumber;

    /**
    * 资金需求
    */
    private Double fundDemand;

    /**
    * 提交时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date submitDate;

    /**
    * 审核通过时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date verifyDate;

    /**
    * 申请的内容，最多两千字
    */
    private String applyContent;

    /**
    * 申请单状态:未处理，不通过，通过
    */
    private String applyStatus;

    /**
    * 合同附件url
    */
    private String fileUrl;
    /**
    * 合同附件名字
    */
    private String fileName;

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    private String applyUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplyTitle() {
        return applyTitle;
    }

    public void setApplyTitle(String applyTitle) {
        this.applyTitle = applyTitle;
    }

    public String getApplyType() {
        return applyType;
    }

    public void setApplyType(String applyType) {
        this.applyType = applyType;
    }

    public String getApplyNumber() {
        return applyNumber;
    }

    public void setApplyNumber(String applyNumber) {
        this.applyNumber = applyNumber;
    }

    public Double getFundDemand() {
        return fundDemand;
    }

    public void setFundDemand(Double fundDemand) {
        this.fundDemand = fundDemand;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public Date getVerifyDate() {
        return verifyDate;
    }

    public void setVerifyDate(Date verifyDate) {
        this.verifyDate = verifyDate;
    }

    public String getApplyContent() {
        return applyContent;
    }

    public void setApplyContent(String applyContent) {
        this.applyContent = applyContent;
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}