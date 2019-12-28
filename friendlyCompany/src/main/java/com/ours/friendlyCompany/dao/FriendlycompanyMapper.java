package com.ours.friendlyCompany.dao;

import com.ours.friendlyCompany.entity.Friendlycompany;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface FriendlycompanyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Friendlycompany record);

    int insertSelective(Friendlycompany record);

    Friendlycompany selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Friendlycompany record);

    int updateByPrimaryKey(Friendlycompany record);

    List<Map<String, Object>> queryAllValue();

}