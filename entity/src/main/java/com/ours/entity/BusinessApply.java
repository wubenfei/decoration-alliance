package com.ours.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
}