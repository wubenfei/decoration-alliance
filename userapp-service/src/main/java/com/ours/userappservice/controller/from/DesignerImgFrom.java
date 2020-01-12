package com.ours.userappservice.controller.from;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class DesignerImgFrom {
    private int id;

    private String img;

    public DesignerImgFrom(int id, String img) {
        this.id = id;
        this.img = img;
    }

    public DesignerImgFrom() {
    }
}
