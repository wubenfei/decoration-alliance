package com.ours.friendlyCompany.entity;

import java.util.Date;

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
     * 员工工号
     */
    private String jobNumber;

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

    /**
     * 员工职级
     */
    private String roleName;

    /**
     * 紧急手机号码
     */
    private String tel;

    /**
     * 家庭住址
     */
    private String addr;

    /**
     * 身份证号码
     */
    private String idCard;

    /**
     * 入职时间
     */
    private Date joinDate;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
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
        sb.append(", url=").append(url);
        sb.append(", jobNumber=").append(jobNumber);
        sb.append(", wages=").append(wages);
        sb.append(", staffName=").append(staffName);
        sb.append(", phone=").append(phone);
        sb.append(", password=").append(password);
        sb.append(", status=").append(status);
        sb.append(", roleId=").append(roleId);
        sb.append(", roleName=").append(roleName);
        sb.append(", tel=").append(tel);
        sb.append(", addr=").append(addr);
        sb.append(", idCard=").append(idCard);
        sb.append(", joinDate=").append(joinDate);
        sb.append(", dismissionDate=").append(dismissionDate);
        sb.append("]");
        return sb.toString();
    }
}