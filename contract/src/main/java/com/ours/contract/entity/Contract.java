package com.ours.contract.entity;

import java.util.Date;

public class Contract {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 设计师id
     */
    private Integer designerId;

    /**
     * 装修施工方id
     */
    private Integer decorationCompanyId;

    /**
     * 员工id
     */
    private Integer staffId;

    /**
     * 合同编号
     */
    private String contractNumber;

    /**
     * 合同名称
     */
    private String contractName;

    /**
     * 合同签署时间
     */
    private Date signingTime;

    /**
     * 合同有效时间
     */
    private String validityOfContract;

    /**
     * 合同到期时间
     */
    private Date dueTime;

    /**
     * 合同内容pdf文件地址
     */
    private String contentOfContract;

    /**
     * 合同补充内容pdf文件地址
     */
    private String supplementaryContentsOfTheContract;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDesignerId() {
        return designerId;
    }

    public void setDesignerId(Integer designerId) {
        this.designerId = designerId;
    }

    public Integer getDecorationCompanyId() {
        return decorationCompanyId;
    }

    public void setDecorationCompanyId(Integer decorationCompanyId) {
        this.decorationCompanyId = decorationCompanyId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public Date getSigningTime() {
        return signingTime;
    }

    public void setSigningTime(Date signingTime) {
        this.signingTime = signingTime;
    }

    public String getValidityOfContract() {
        return validityOfContract;
    }

    public void setValidityOfContract(String validityOfContract) {
        this.validityOfContract = validityOfContract;
    }

    public Date getDueTime() {
        return dueTime;
    }

    public void setDueTime(Date dueTime) {
        this.dueTime = dueTime;
    }

    public String getContentOfContract() {
        return contentOfContract;
    }

    public void setContentOfContract(String contentOfContract) {
        this.contentOfContract = contentOfContract;
    }

    public String getSupplementaryContentsOfTheContract() {
        return supplementaryContentsOfTheContract;
    }

    public void setSupplementaryContentsOfTheContract(String supplementaryContentsOfTheContract) {
        this.supplementaryContentsOfTheContract = supplementaryContentsOfTheContract;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", designerId=").append(designerId);
        sb.append(", decorationCompanyId=").append(decorationCompanyId);
        sb.append(", staffId=").append(staffId);
        sb.append(", contractNumber=").append(contractNumber);
        sb.append(", contractName=").append(contractName);
        sb.append(", signingTime=").append(signingTime);
        sb.append(", validityOfContract=").append(validityOfContract);
        sb.append(", dueTime=").append(dueTime);
        sb.append(", contentOfContract=").append(contentOfContract);
        sb.append(", supplementaryContentsOfTheContract=").append(supplementaryContentsOfTheContract);
        sb.append("]");
        return sb.toString();
    }
}