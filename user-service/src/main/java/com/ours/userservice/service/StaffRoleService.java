package com.ours.userservice.service;

import com.ours.entity.StaffRole;

import java.util.List;

public interface StaffRoleService {


    int deleteByPrimaryKey(Integer id);

    int insert(StaffRole record);

    int insertSelective(StaffRole record);

    StaffRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StaffRole record);

    int updateByPrimaryKey(StaffRole record);

    List<StaffRole> getRoleName();


}
