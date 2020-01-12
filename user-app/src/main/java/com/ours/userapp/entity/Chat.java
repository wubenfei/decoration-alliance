package com.ours.userapp.entity;

import lombok.Data;

@Data
public class Chat {
    private Integer chatId;

    /**
    * 聊天记录的json字符串
    */
    private String chatText;
}