package com.ours.userapp.mapper;

import com.ours.entity.ChatRecord;

public interface ChatRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ChatRecord record);

    int insertSelective(ChatRecord record);

    ChatRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChatRecord record);

    int updateByPrimaryKey(ChatRecord record);
}