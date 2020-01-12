package com.ours.entity;

import java.util.Date;

public class Step {
    /**
    * 主键id
    */
    private Integer id;

    /**
    * 合同id
    */
    private Integer contractid;

    /**
    * 监督图片
    */
    private String img1;

    /**
    * 监督图片
    */
    private String img2;

    /**
    * 监督图片
    */
    private String img3;

    /**
    * 监督图片
    */
    private String img4;

    /**
    * 监督图片
    */
    private String img5;

    private String img6;

    private String img7;

    private Date time1;

    private Date time2;

    private Date time3;

    private Date time4;

    private Date time5;

    private Date time6;

    private Date time7;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getContractid() {
        return contractid;
    }

    public void setContractid(Integer contractid) {
        this.contractid = contractid;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    public String getImg4() {
        return img4;
    }

    public void setImg4(String img4) {
        this.img4 = img4;
    }

    public String getImg5() {
        return img5;
    }

    public void setImg5(String img5) {
        this.img5 = img5;
    }

    public String getImg6() {
        return img6;
    }

    public void setImg6(String img6) {
        this.img6 = img6;
    }

    public String getImg7() {
        return img7;
    }

    public void setImg7(String img7) {
        this.img7 = img7;
    }

    public Date getTime1() {
        return time1;
    }

    public void setTime1(Date time1) {
        this.time1 = time1;
    }

    public Date getTime2() {
        return time2;
    }

    public void setTime2(Date time2) {
        this.time2 = time2;
    }

    public Date getTime3() {
        return time3;
    }

    public void setTime3(Date time3) {
        this.time3 = time3;
    }

    public Date getTime4() {
        return time4;
    }

    public void setTime4(Date time4) {
        this.time4 = time4;
    }

    public Date getTime5() {
        return time5;
    }

    public void setTime5(Date time5) {
        this.time5 = time5;
    }

    public Date getTime6() {
        return time6;
    }

    public void setTime6(Date time6) {
        this.time6 = time6;
    }

    public Date getTime7() {
        return time7;
    }

    public void setTime7(Date time7) {
        this.time7 = time7;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", contractid=").append(contractid);
        sb.append(", img1=").append(img1);
        sb.append(", img2=").append(img2);
        sb.append(", img3=").append(img3);
        sb.append(", img4=").append(img4);
        sb.append(", img5=").append(img5);
        sb.append(", img6=").append(img6);
        sb.append(", img7=").append(img7);
        sb.append(", time1=").append(time1);
        sb.append(", time2=").append(time2);
        sb.append(", time3=").append(time3);
        sb.append(", time4=").append(time4);
        sb.append(", time5=").append(time5);
        sb.append(", time6=").append(time6);
        sb.append(", time7=").append(time7);
        sb.append("]");
        return sb.toString();
    }
}