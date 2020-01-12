package com.ours.userapp.mapper;


import com.ours.userapp.entity.Chat;


import java.util.List;

public interface ChatMapper {
    int deleteByPrimaryKey(Integer chatId);

    int insert(Chat record);

    int insertSelective(Chat record);

    Chat selectByPrimaryKey(Integer chatId);

    int updateByPrimaryKeySelective(Chat record);

    int updateByPrimaryKey(Chat record);

    void addmessage(String message);

    List<String> queryChat(Integer pageIndex);
}