package com.ours.userapp.mapper;

import com.ours.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User query(String phone);

    int saveUrl(String url, int id);

    int updataPwd(String password, String phone);

}