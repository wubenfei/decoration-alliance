package com.ours.userapp.service.forstaffService.impl;

import com.ours.entity.ChatRecord;
import com.ours.userapp.entity.Chat;
import com.ours.userapp.mapper.ChatMapper;
import com.ours.userapp.mapper.ChatRecordMapper;
import com.ours.userapp.service.forstaffService.ChatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    @Resource
    private ChatMapper chatMapper;
    @Resource()
    private ChatRecordMapper chatRecordMapper;

    @Override
    public int deleteByPrimaryKey(Integer chatId) {
        return chatMapper.deleteByPrimaryKey(chatId);
    }

    @Override
    public int insert(Chat record) {
        return chatMapper.insert(record);
    }

    @Override
    public int insertSelective(Chat record) {
        return chatMapper.insertSelective(record);
    }

    @Override
    public Chat selectByPrimaryKey(Integer chatId) {
        return chatMapper.selectByPrimaryKey(chatId);
    }

    @Override
    public int updateByPrimaryKeySelective(Chat record) {
        return chatMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Chat record) {
        return chatMapper.updateByPrimaryKey(record);
    }

    @Override
    public void addmessage(String message) {
        chatMapper.addmessage(message);
    }

    @Override
    public List<String> queryChat(Integer pageIndex) {
        return chatMapper.queryChat(pageIndex);
    }

    @Override
    public Integer insertChatRecord(ChatRecord chatRecord) {
        return chatRecordMapper.insertSelective(chatRecord);
    }

}
