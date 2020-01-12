package com.ours.userservice.controller.from;

import lombok.Data;

import java.io.Serializable;

@Data
public class DecorationFrom implements Serializable {
    private int id;

    private String company_name;

    private String company_address;

    private String company_intime;

    private String company_phone;

    private String company_idname;

    private String status;

    public DecorationFrom(int id, String company_name, String company_address, String company_intime, String company_phone, String company_idname, String status) {
        this.id = id;
        this.company_name = company_name;
        this.company_address = company_address;
        this.company_intime = company_intime;
        this.company_phone = company_phone;
        this.company_idname = company_idname;
        this.status = status;
    }

    public DecorationFrom() {
    }
}
