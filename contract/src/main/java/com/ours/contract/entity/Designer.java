package com.ours.contract.entity;

public class Designer {
    /**
     * 角色id
     */
    private Integer id;

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
     * 头像地址
     */
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", designerName=").append(designerName);
        sb.append(", designerPhone=").append(designerPhone);
        sb.append(", designerEmail=").append(designerEmail);
        sb.append(", designerPassword=").append(designerPassword);
        sb.append(", designerStatus=").append(designerStatus);
        sb.append(", url=").append(url);
        sb.append("]");
        return sb.toString();
    }
}