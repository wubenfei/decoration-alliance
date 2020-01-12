package com.ours.userappservice.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.ours.entity.UserDes;
import com.ours.userappservice.mapper.UserDesMapper;
import com.ours.userappservice.service.UserDesService;

@Service
public class UserDesServiceImpl implements UserDesService {

    @Resource
    private UserDesMapper userDesMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userDesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserDes record) {
        return userDesMapper.insert(record);
    }

    @Override
    public int insertSelective(UserDes record) {
        return userDesMapper.insertSelective(record);
    }

    @Override
    public UserDes selectByPrimaryKey(Integer id) {
        return userDesMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserDes record) {
        return userDesMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserDes record) {
        return userDesMapper.updateByPrimaryKey(record);
    }

    @Override
    public int countSuccess(Integer desId, Integer status) {
        return userDesMapper.countSuccess(desId, status);
    }

}
