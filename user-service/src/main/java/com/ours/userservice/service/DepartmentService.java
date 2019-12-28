package com.ours.userservice.service;

import com.ours.entity.Department;

import java.util.List;

public interface DepartmentService {


    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> selectStaffAllPermission(Integer depId);

    //根据员工id查出员工所属部门
    Department selectStaffDepartmentByDepId(String jobNumber);

    List<Department> getDepName();

    //根据设计师id查出设计所属部门
    Department selectDesignerStaffDepartmentByDepId(String jobNumber);
}
