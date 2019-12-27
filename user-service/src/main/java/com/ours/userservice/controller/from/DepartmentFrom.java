package com.ours.userservice.controller.from;

import lombok.Data;

@Data
public class DepartmentFrom {
    private String departName;

    private String departValue;

    private Boolean disabled;

    public DepartmentFrom(String departName, String departValue, Boolean disabled) {
        this.departName = departName;
        this.departValue = departValue;
        this.disabled = disabled;
    }

    public DepartmentFrom() {
    }
}
