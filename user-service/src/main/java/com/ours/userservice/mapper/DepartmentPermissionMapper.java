package com.ours.userservice.mapper;

import com.ours.entity.DepartmentPermission;

public interface DepartmentPermissionMapper {
    int insert(DepartmentPermission record);

    int insertSelective(DepartmentPermission record);
}