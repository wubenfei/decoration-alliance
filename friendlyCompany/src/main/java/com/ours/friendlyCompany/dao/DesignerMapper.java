package com.ours.friendlyCompany.dao;

import com.ours.friendlyCompany.entity.Designer;

public interface DesignerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Designer record);

    int insertSelective(Designer record);

    Designer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Designer record);

    int updateByPrimaryKey(Designer record);

    Designer queryDesignerByIdcard(String id_card);
}