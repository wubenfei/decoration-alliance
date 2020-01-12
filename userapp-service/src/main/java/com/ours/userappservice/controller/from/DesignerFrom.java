package com.ours.userappservice.controller.from;

import lombok.Data;

@Data
public class DesignerFrom {
    private int desId;

    private int userId;

    private String img;

    private String name;

    private int slogan;

    public DesignerFrom(int desId, int userId, String img, String name, int slogan) {
        this.desId = desId;
        this.userId = userId;
        this.img = img;
        this.name = name;
        this.slogan = slogan;
    }

    public DesignerFrom() {
    }
}
