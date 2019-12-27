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
     * 用户身份证
     */
    private String userIdcard;

    /**
     * 用户电话
     */
    private String userPhone;

    /**
     * 设计师id
     */
    private Integer designerId;

    /**
     * 设计师身份证
     */
    private String designerIdcard;

    /**
     * 设计师电话
     */
    private String designerPhone;

    /**
     * 装修施工方id
    */
    private Integer decorationCompanyId;

    /**
     * 装修施工方身份证
     */
    private String decorationCompanyIdcard;

    /**
     * 装修施工方电话
     */
    private String decorationCompanyPhone;

    /**
     * 员工id
    */
    private Integer staffId;

    /**
     * 平台证件号
     */
    private String staffCard;

    /**
     * 员工电话
     */
    private String staffPhone;

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

    /**
     * 设计合同,装修合同
     */
    private String contractType;

    /**
     * 合同状态:进行中,已完成,异常终止
     */
    private String contractStatus;

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

    public String getUserIdcard() {
        return userIdcard;
    }

    public void setUserIdcard(String userIdcard) {
        this.userIdcard = userIdcard;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Integer getDesignerId() {
        return designerId;
    }

    public void setDesignerId(Integer designerId) {
        this.designerId = designerId;
    }

    public String getDesignerIdcard() {
        return designerIdcard;
    }

    public void setDesignerIdcard(String designerIdcard) {
        this.designerIdcard = designerIdcard;
    }

    public String getDesignerPhone() {
        return designerPhone;
    }

    public void setDesignerPhone(String designerPhone) {
        this.designerPhone = designerPhone;
    }

    public Integer getDecorationCompanyId() {
        return decorationCompanyId;
    }

    public void setDecorationCompanyId(Integer decorationCompanyId) {
        this.decorationCompanyId = decorationCompanyId;
    }

    public String getDecorationCompanyIdcard() {
        return decorationCompanyIdcard;
    }

    public void setDecorationCompanyIdcard(String decorationCompanyIdcard) {
        this.decorationCompanyIdcard = decorationCompanyIdcard;
    }

    public String getDecorationCompanyPhone() {
        return decorationCompanyPhone;
    }

    public void setDecorationCompanyPhone(String decorationCompanyPhone) {
        this.decorationCompanyPhone = decorationCompanyPhone;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getStaffCard() {
        return staffCard;
    }

    public void setStaffCard(String staffCard) {
        this.staffCard = staffCard;
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
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

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public String getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", userIdcard=").append(userIdcard);
        sb.append(", userPhone=").append(userPhone);
        sb.append(", designerId=").append(designerId);
        sb.append(", designerIdcard=").append(designerIdcard);
        sb.append(", designerPhone=").append(designerPhone);
        sb.append(", decorationCompanyId=").append(decorationCompanyId);
        sb.append(", decorationCompanyIdcard=").append(decorationCompanyIdcard);
        sb.append(", decorationCompanyPhone=").append(decorationCompanyPhone);
        sb.append(", staffId=").append(staffId);
        sb.append(", staffCard=").append(staffCard);
        sb.append(", staffPhone=").append(staffPhone);
        sb.append(", contractNumber=").append(contractNumber);
        sb.append(", contractName=").append(contractName);
        sb.append(", signingTime=").append(signingTime);
        sb.append(", validityOfContract=").append(validityOfContract);
        sb.append(", dueTime=").append(dueTime);
        sb.append(", contentOfContract=").append(contentOfContract);
        sb.append(", supplementaryContentsOfTheContract=").append(supplementaryContentsOfTheContract);
        sb.append(", contractType=").append(contractType);
        sb.append(", contractStatus=").append(contractStatus);
        sb.append("]");
        return sb.toString();
    }
}