package com.ours.userservice.service;

import com.ours.entity.StaffDep;

public interface StaffDepService {


    int insert(StaffDep record);

    int insertSelective(StaffDep record);

    int updateStaffDep(String depId, String jobNumber);

}
