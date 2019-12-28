package com.ours.userservice.mapper;

import com.ours.entity.StaffRole;

import java.util.List;

public interface StaffRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StaffRole record);

    int insertSelective(StaffRole record);

    StaffRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StaffRole record);

    int updateByPrimaryKey(StaffRole record);

    List<StaffRole> getRoleName();


}