package com.ours.friendlyCompany.dao;

import com.ours.friendlyCompany.entity.StaffRole;

public interface StaffRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StaffRole record);

    int insertSelective(StaffRole record);

    StaffRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StaffRole record);

    int updateByPrimaryKey(StaffRole record);
}