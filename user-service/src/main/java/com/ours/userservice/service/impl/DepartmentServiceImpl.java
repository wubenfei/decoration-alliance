package com.ours.userservice.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.ours.userservice.mapper.DepartmentMapper;
import com.ours.entity.Department;
import com.ours.userservice.service.DepartmentService;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    private DepartmentMapper departmentMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return departmentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Department record) {
        return departmentMapper.insert(record);
    }

    @Override
    public int insertSelective(Department record) {
        return departmentMapper.insertSelective(record);
    }

    @Override
    public Department selectByPrimaryKey(Integer id) {
        return departmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Department record) {
        return departmentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Department record) {
        return departmentMapper.updateByPrimaryKey(record);
    }

    public List<Department> selectStaffAllPermission(Integer depId) {
        return departmentMapper.selectStaffAllPermission(depId);
    }

    @Override
    public Department selectStaffDepartmentByDepId(String jobNumber) {
        return departmentMapper.selectStaffDepartmentByDepId(jobNumber);
    }

    @Override
    public List<Department> getDepName() {
        return departmentMapper.getDepName();
    }

    @Override
    public Department selectDesignerStaffDepartmentByDepId(String jobNumber) {
        return departmentMapper.selectDesignerStaffDepartmentByDepId(jobNumber);
    }

    ;

}
