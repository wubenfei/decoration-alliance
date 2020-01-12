package com.ours.entity;

public class House {
    /**
    * 房屋id
    */
    private Integer id;

    /**
    * 房屋地址
    */
    private String houseAddress;

    /**
    * 房屋高度
    */
    private Double houseHeight;

    /**
    * 房屋面积
    */
    private Double houseArea;

    /**
    * 户型
    */
    private String houseType;

    /**
    * 用户id
    */
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public Double getHouseHeight() {
        return houseHeight;
    }

    public void setHouseHeight(Double houseHeight) {
        this.houseHeight = houseHeight;
    }

    public Double getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(Double houseArea) {
        this.houseArea = houseArea;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", houseAddress=").append(houseAddress);
        sb.append(", houseHeight=").append(houseHeight);
        sb.append(", houseArea=").append(houseArea);
        sb.append(", houseType=").append(houseType);
        sb.append(", userId=").append(userId);
        sb.append("]");
        return sb.toString();
    }
}