package com.ours.userservice.controller.from;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
public class StaffFrom {
    private String kind;

    private String jobNumber;

    private String staffName;

    private String depName;

    private String phone;

    private String roleName;

    private String joinDate;

    private String status;

    private String dismissionDate;

    public StaffFrom(String kind, String jobNumber, String staffName, String depName, String phone, String roleName, String joinDate, String status, String dismissionDate) {
        this.kind = kind;
        this.jobNumber = jobNumber;
        this.staffName = staffName;
        this.depName = depName;
        this.phone = phone;
        this.roleName = roleName;
        this.joinDate = joinDate;
        this.status = status;
        this.dismissionDate = dismissionDate;
    }

    public StaffFrom() {
    }
}
