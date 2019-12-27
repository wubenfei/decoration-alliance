package com.ours.userservice.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.ours.entity.DepartmentPermission;
import com.ours.userservice.mapper.DepartmentPermissionMapper;
import com.ours.userservice.service.DepartmentPermissionService;

@Service
public class DepartmentPermissionServiceImpl implements DepartmentPermissionService {

    @Resource
    private DepartmentPermissionMapper departmentPermissionMapper;

    @Override
    public int insert(DepartmentPermission record) {
        return departmentPermissionMapper.insert(record);
    }

    @Override
    public int insertSelective(DepartmentPermission record) {
        return departmentPermissionMapper.insertSelective(record);
    }

}
