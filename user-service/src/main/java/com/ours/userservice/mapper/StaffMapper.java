package com.ours.userservice.mapper;

import com.ours.entity.Staff;

import java.util.Date;
import java.util.List;

public interface StaffMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);

    Staff selectPhoneAndPassword(String username, String password);

    List<Staff> selectAllStaff();

    int updateByStatusAndDismissionDate(String status, Date dismissionDate, String jobNumber);

    int updateRoleName(String roleName, String jobNumber);

    Staff selectJobNumber(String jobNumber);
}