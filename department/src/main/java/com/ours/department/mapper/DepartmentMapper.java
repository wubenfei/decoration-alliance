package com.ours.department.mapper;

import com.ours.entity.Department;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer depId);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer depId);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> selectDeps();
}