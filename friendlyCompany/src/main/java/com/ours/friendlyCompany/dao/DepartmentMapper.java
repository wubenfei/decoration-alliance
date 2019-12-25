package com.ours.friendlyCompany.dao;

import com.ours.friendlyCompany.entity.Department;

import java.util.List;
import java.util.Map;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Map<String, Object>> getAllDepartments();

    List<Map<String, Object>> queryAllLevel();
}