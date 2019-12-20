package com.ours.department.service.impl;

import com.ours.department.mapper.DepartmentMapper;
import com.ours.department.service.DepartmentService;
import com.ours.entity.Department;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentMapper departmentMapper;

    @Override
    public int deleteByPrimaryKey(Integer depId) {
        return departmentMapper.deleteByPrimaryKey(depId);
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
    public Department selectByPrimaryKey(Integer depId) {
        return departmentMapper.selectByPrimaryKey(depId);
    }

    @Override
    public int updateByPrimaryKeySelective(Department record) {
        return departmentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Department record) {
        return departmentMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Department> selectDeps() {
        System.out.println("草泥马 我的数据被你吃了？"+departmentMapper.selectDeps());
        return departmentMapper.selectDeps();
    }

}
