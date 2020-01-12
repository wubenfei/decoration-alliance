package com.ours.entity;

import java.util.Date;
import lombok.Data;

@Data
public class ChatRecord {
    /**
    * 聊天id
    */
    private Integer id;

    /**
    * 发送方id
    */
    private String sendId;

    /**
    * 发送方昵称
    */
    private String sendName;

    /**
    * 接收方id
    */
    private String receiverId;

    /**
    * 接收方昵称
    */
    private String receiverName;

    /**
    * 聊天内容
    */
    private String content;

    /**
    * 阅读状态 : 1-已读;0-未读
    */
    private Integer status;

    /**
    * 发送时间
    */
    private Date sendTime;

    /**
    * text,img
    */
    private String type;

    private String other;

    /**
    * 图片宽
    */
    private Integer w;

    /**
    * 高
    */
    private Integer h;
}