package com.ours.entity;

import java.util.Date;

public class Designer {
    /**
     * 角色id
     */
    private Integer id;

    /**
     * 设计师工号
     */
    private String designerJob;

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
     * 设计师职级
     */
    private String roleName;

    /**
     * 头像地址
     */
    private String url;

    /**
     * 入职时间
     */
    private Date joinData;

    /**
     * 离职时间
     */
    private Date dismissionDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesignerJob() {
        return designerJob;
    }

    public void setDesignerJob(String designerJob) {
        this.designerJob = designerJob;
    }

    public String getDesignerName() {
        return designerName;
    }

    public void setDesignerName(String designerName) {
        this.designerName = designerName;
    }

    public String getDesignerPhone() {
        return designerPhone;
    }

    public void setDesignerPhone(String designerPhone) {
        this.designerPhone = designerPhone;
    }

    public String getDesignerEmail() {
        return designerEmail;
    }

    public void setDesignerEmail(String designerEmail) {
        this.designerEmail = designerEmail;
    }

    public String getDesignerPassword() {
        return designerPassword;
    }

    public void setDesignerPassword(String designerPassword) {
        this.designerPassword = designerPassword;
    }

    public String getDesignerStatus() {
        return designerStatus;
    }

    public void setDesignerStatus(String designerStatus) {
        this.designerStatus = designerStatus;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getJoinData() {
        return joinData;
    }

    public void setJoinData(Date joinData) {
        this.joinData = joinData;
    }

    public Date getDismissionDate() {
        return dismissionDate;
    }

    public void setDismissionDate(Date dismissionDate) {
        this.dismissionDate = dismissionDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", designerJob=").append(designerJob);
        sb.append(", designerName=").append(designerName);
        sb.append(", designerPhone=").append(designerPhone);
        sb.append(", designerEmail=").append(designerEmail);
        sb.append(", designerPassword=").append(designerPassword);
        sb.append(", designerStatus=").append(designerStatus);
        sb.append(", roleName=").append(roleName);
        sb.append(", url=").append(url);
        sb.append(", joinData=").append(joinData);
        sb.append(", dismissionDate=").append(dismissionDate);
        sb.append("]");
        return sb.toString();
    }
}