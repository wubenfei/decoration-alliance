package com.ours.userservice.service;

import com.ours.entity.Permission;

import java.util.List;

public interface PermissionService {


    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    List<Permission> selectStaffAllPermission(String jobNumber);

}
