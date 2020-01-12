package com.ours.entity;

public class DesignerEffect {
    /**
    * 主键
    */
    private Integer id;

    /**
    * 设计师id
    */
    private Integer designerId;

    /**
    * 用户id
    */
    private Integer userId;

    /**
    * 效果图1
    */
    private String designerImg1;

    /**
    * 效果图2
    */
    private String designerImg2;

    /**
    * 效果图3
    */
    private String designerImg3;

    /**
    * 效果图4
    */
    private String designerImg4;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDesignerId() {
        return designerId;
    }

    public void setDesignerId(Integer designerId) {
        this.designerId = designerId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDesignerImg1() {
        return designerImg1;
    }

    public void setDesignerImg1(String designerImg1) {
        this.designerImg1 = designerImg1;
    }

    public String getDesignerImg2() {
        return designerImg2;
    }

    public void setDesignerImg2(String designerImg2) {
        this.designerImg2 = designerImg2;
    }

    public String getDesignerImg3() {
        return designerImg3;
    }

    public void setDesignerImg3(String designerImg3) {
        this.designerImg3 = designerImg3;
    }

    public String getDesignerImg4() {
        return designerImg4;
    }

    public void setDesignerImg4(String designerImg4) {
        this.designerImg4 = designerImg4;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", designerId=").append(designerId);
        sb.append(", userId=").append(userId);
        sb.append(", designerImg1=").append(designerImg1);
        sb.append(", designerImg2=").append(designerImg2);
        sb.append(", designerImg3=").append(designerImg3);
        sb.append(", designerImg4=").append(designerImg4);
        sb.append("]");
        return sb.toString();
    }
}