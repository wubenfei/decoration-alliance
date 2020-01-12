package com.ours.userapp.mapper;

import com.ours.entity.UserDec;

import java.util.List;

public interface UserDecMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserDec record);

    int insertSelective(UserDec record);

    UserDec selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserDec record);

    int updateByPrimaryKey(UserDec record);

}