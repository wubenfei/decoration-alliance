package com.ours.userservice.controller.from;

import lombok.Data;

@Data
public class RoleFrom {
    private String roleName;
    private String roleValue;
    private Boolean disabled;

    public RoleFrom(String roleName, String roleValue, Boolean disabled) {
        this.roleName = roleName;
        this.roleValue = roleValue;
        this.disabled = disabled;
    }

    public RoleFrom() {
    }
}
