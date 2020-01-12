package com.ours.entity;

import java.io.Serializable;

public class Friendlycompany implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 友商种类表主键
     */
    private Integer id;

    private String friendlyCompanyKind;

    /**
     * 友商种类名
     */
    private String friendlyCompanyValue;

    private Integer roleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFriendlyCompanyKind() {
        return friendlyCompanyKind;
    }

    public void setFriendlyCompanyKind(String friendlyCompanyKind) {
        this.friendlyCompanyKind = friendlyCompanyKind;
    }

    public String getFriendlyCompanyValue() {
        return friendlyCompanyValue;
    }

    public void setFriendlyCompanyValue(String friendlyCompanyValue) {
        this.friendlyCompanyValue = friendlyCompanyValue;
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
        sb.append(", friendlyCompanyKind=").append(friendlyCompanyKind);
        sb.append(", friendlyCompanyValue=").append(friendlyCompanyValue);
        sb.append(", roleId=").append(roleId);
        sb.append("]");
        return sb.toString();
    }
}