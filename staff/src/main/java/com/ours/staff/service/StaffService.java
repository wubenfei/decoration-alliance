package com.ours.staff.service;

import com.ours.entity.Staff;

import java.util.List;

public interface StaffService {


    int deleteByPrimaryKey(Integer id);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);

    /**
     * @param depId
     * @return
     * @Auth:MrW
     */
    List<Staff> selectDepMembersByDepId(String depId);
}

