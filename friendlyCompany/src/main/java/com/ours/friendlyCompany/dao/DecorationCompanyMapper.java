package com.ours.friendlyCompany.dao;

import com.ours.friendlyCompany.entity.DecorationCompany;

public interface DecorationCompanyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DecorationCompany record);

    int insertSelective(DecorationCompany record);

    DecorationCompany selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DecorationCompany record);

    int updateByPrimaryKey(DecorationCompany record);
}