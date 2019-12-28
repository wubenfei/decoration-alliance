package com.ours.friendlyCompany.dao;

import com.ours.friendlyCompany.entity.StaffDep;

public interface StaffDepMapper {
    int insert(StaffDep record);

    int insertSelective(StaffDep record);
}