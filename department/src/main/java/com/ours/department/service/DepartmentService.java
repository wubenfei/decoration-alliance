package com.ours.department.service;

import com.ours.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentService{

    public int deleteByPrimaryKey(Integer depId);


    public int insert(Department record);


    public int insertSelective(Department record);


    public Department selectByPrimaryKey(Integer depId);


    public int updateByPrimaryKeySelective(Department record);


    public int updateByPrimaryKey(Department record);


    List<Department> selectDeps();
}
