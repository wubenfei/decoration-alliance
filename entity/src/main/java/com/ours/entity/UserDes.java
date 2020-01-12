package com.ours.entity;

public class UserDes {
    private Integer id;

    private Integer userId;

    /**
    * 设计师
    */
    private Integer desId;

    private String userName;

    /**
    * 客户状态:0-合作崩了,1-合作中,2-合作结束
    */
    private Integer userStatus;

    /**
    * 设计师状态:0-合作崩了,1-合作中,2-合作结束
    */
    private Integer desStatus;

    /**
    * 是否:1-显示,0-不显示
    */
    private Integer in;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDesId() {
        return desId;
    }

    public void setDesId(Integer desId) {
        this.desId = desId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getDesStatus() {
        return desStatus;
    }

    public void setDesStatus(Integer desStatus) {
        this.desStatus = desStatus;
    }

    public Integer getIn() {
        return in;
    }

    public void setIn(Integer in) {
        this.in = in;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", desId=").append(desId);
        sb.append(", userName=").append(userName);
        sb.append(", userStatus=").append(userStatus);
        sb.append(", desStatus=").append(desStatus);
        sb.append(", in=").append(in);
        sb.append("]");
        return sb.toString();
    }
}