package com.ours.entity;

import java.io.Serializable;

public class Permission implements Serializable {
    /**
     * 权限id
     */
    private Integer id;

    /**
     * 权限名(英语的那个)
     */
    private String permissionName;

    /**
     * 权限名(中文的那个)
     */
    private String permissionValue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionValue() {
        return permissionValue;
    }

    public void setPermissionValue(String permissionValue) {
        this.permissionValue = permissionValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", permissionName=").append(permissionName);
        sb.append(", permissionValue=").append(permissionValue);
        sb.append("]");
        return sb.toString();
    }
}