package com.ours.userappservice.service;

import com.ours.entity.UserDes;

public interface UserDesService {


    int deleteByPrimaryKey(Integer id);

    int insert(UserDes record);

    int insertSelective(UserDes record);

    UserDes selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserDes record);

    int updateByPrimaryKey(UserDes record);

    int countSuccess(Integer desId, Integer status);

}
