package com.ours.entity;

public class StaffRole {
    /**
     * 角色id
     */
    private Integer id;

    /**
     * 员工角色英文名
     */
    private String staffRoleName;

    /**
     * 员工角色中文名
     */
    private String staffRoleValue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStaffRoleName() {
        return staffRoleName;
    }

    public void setStaffRoleName(String staffRoleName) {
        this.staffRoleName = staffRoleName;
    }

    public String getStaffRoleValue() {
        return staffRoleValue;
    }

    public void setStaffRoleValue(String staffRoleValue) {
        this.staffRoleValue = staffRoleValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", staffRoleName=").append(staffRoleName);
        sb.append(", staffRoleValue=").append(staffRoleValue);
        sb.append("]");
        return sb.toString();
    }
}