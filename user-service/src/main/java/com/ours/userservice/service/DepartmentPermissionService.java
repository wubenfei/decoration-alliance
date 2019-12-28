package com.ours.userservice.service;

import com.ours.entity.DepartmentPermission;

public interface DepartmentPermissionService {


    int insert(DepartmentPermission record);

    int insertSelective(DepartmentPermission record);

}
