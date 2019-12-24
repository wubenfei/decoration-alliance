package com.ours.contract.entity;

public class Staff {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 员工头像
     */
    private String url;

    /**
     * 工资
     */
    private String wages;

    /**
     * 员工姓名
     */
    private String staffName;

    /**
     * 员工电话
     */
    private String phone;

    /**
     * 员工登录密码
     */
    private String password;

    /**
     * 员工状态
     */
    private String status;

    /**
     * 角色id
     */
    private Integer roleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWages() {
        return wages;
    }

    public void setWages(String wages) {
        this.wages = wages;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", url=").append(url);
        sb.append(", wages=").append(wages);
        sb.append(", staffName=").append(staffName);
        sb.append(", phone=").append(phone);
        sb.append(", password=").append(password);
        sb.append(", status=").append(status);
        sb.append(", roleId=").append(roleId);
        sb.append("]");
        return sb.toString();
    }
}