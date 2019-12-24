package com.ours.department.mapper;

import com.ours.entity.Department;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
//以下为自定义
    List<Department> selectDeps();

    Department selectByDepId(String depId);

    int deleteByDepId(String depId);
}