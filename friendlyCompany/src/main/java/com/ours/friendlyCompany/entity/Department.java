package com.ours.friendlyCompany.entity;

public class Department {
    private Integer id;

    /**
     * 部门编号
     */
    private String depId;

    /**
     * 部门名字
     */
    private String depName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", depId=").append(depId);
        sb.append(", depName=").append(depName);
        sb.append("]");
        return sb.toString();
    }
}