package com.ours.department.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ours.entity.Department;
import com.ours.department.mapper.DepartmentMapper;
@Service
public class DepartmentService{

    @Resource
    private DepartmentMapper departmentMapper;

    
    public int deleteByPrimaryKey(Integer depId) {
        return departmentMapper.deleteByPrimaryKey(depId);
    }

    
    public int insert(Department record) {
        return departmentMapper.insert(record);
    }

    
    public int insertSelective(Department record) {
        return departmentMapper.insertSelective(record);
    }

    
    public Department selectByPrimaryKey(Integer depId) {
        return departmentMapper.selectByPrimaryKey(depId);
    }

    
    public int updateByPrimaryKeySelective(Department record) {
        return departmentMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Department record) {
        return departmentMapper.updateByPrimaryKey(record);
    }

}
