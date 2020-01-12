package com.ours.userapp.service.forstaffService.impl;

import com.ours.userapp.mapper.DesignerMapper;
import com.ours.userapp.service.forstaffService.Forstaff_getUserDesListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Forstaff_getUserDesListServiceImpl implements Forstaff_getUserDesListService {
    @Autowired
    private DesignerMapper designerMapper;

    @Override
    public List<Map<String, Object>> queryUserList(Integer des_id) {
        return designerMapper.queryUserList(des_id);
    }

    @Override
    public int changNotIn(Integer id) {
        return designerMapper.changNotIn(id);
    }

    @Override
    public int changIn(Integer id) {
        return designerMapper.changIn(id);
    }

    @Override
    public List<Integer> getUsersId(Integer des_id) {
        return designerMapper.getUsersId(des_id);
    }

    @Override
    public String getUsertitle() {
        return designerMapper.getUsertitle();
    }

    @Override
    public String getDesignertitle() {
        return designerMapper.getDesignertitle();
    }


    @Override
    public Map<String, Object> queryLastChat(String s, String s1) {
        return designerMapper.queryLastChat(s, s1);
    }

    @Override
    public List<Map<String, Object>> queryOneUser(String key, Integer des_id) {
        return designerMapper.queryOneUser(key, des_id);
    }

    @Override
    public List<Integer> getUsersIdByName(String key, Integer des_id) {
        return designerMapper.getUsersIdByName(key, des_id);
    }

    @Override
    public Integer queryNumNotstatus(String s, String s1) {
        return designerMapper.queryNumNotstatus(s,s1);
    }

    @Override
    public List<Integer> getDessId(Integer user_id) {
        return designerMapper.getDessID(user_id);
    }


    @Override
    public List<Map<String, Object>> queryDesList(Integer user_id) {
        return designerMapper.queryDesList(user_id);
    }

    @Override
    public List<Integer> getUsersIdRe(Integer userId, String username) {
        return designerMapper.getUsersIdRe(userId,username);
    }

    @Override
    public List<Map<String, Object>> queryUserListRe(Integer userId, String username) {
        return designerMapper.queryUserListRe(userId,username);
    }

    @Override
    public List<String> getAllUsername(Integer userId, String keyword) {
        return designerMapper.getAllUsername(userId,keyword);
    }
}
