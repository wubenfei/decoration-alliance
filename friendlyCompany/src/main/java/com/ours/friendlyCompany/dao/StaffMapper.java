package com.ours.friendlyCompany.dao;

import com.ours.friendlyCompany.entity.Staff;

public interface StaffMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);

    String queryMaxDesigner_name();

    Staff queryByIdcard(String id_card);
}