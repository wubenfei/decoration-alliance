package com.ours.userapp.service.forstaffService.impl;

import com.ours.userapp.mapper.DesignerMapper;
import com.ours.userapp.service.forstaffService.Forstaff_chatListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Forstaff_chatListServiceImpl implements Forstaff_chatListService {
    @Autowired
    private DesignerMapper designerMapper;
    @Override
    public List<Map<String, Object>> getChatList(String s, String s1) {
        return designerMapper.getChatList(s,s1);
    }

    @Override
    public String qureyUrl(Integer user_id) {
        return designerMapper.qureyUrl(user_id);
    }

    @Override
    public String qureyDesUrl(Integer des_id) {
        return designerMapper.qureyDesUrl(des_id);
    }

    @Override
    public Integer changeChatListStatus(String s, String s1) {
        return designerMapper.changeChatListStatus(s,s1);
    }
}
