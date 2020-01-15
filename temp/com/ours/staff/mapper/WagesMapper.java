package com.ours.staff.mapper;

import tem.Wages;

public interface WagesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Wages record);

    int insertSelective(Wages record);

    Wages selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Wages record);

    int updateByPrimaryKey(Wages record);
}