package com.ours.userservice.mapper;

import com.ours.entity.StaffDep;

public interface StaffDepMapper {
    int insert(StaffDep record);

    int insertSelective(StaffDep record);

    int updateStaffDep(String depId, String jobNumber);
}