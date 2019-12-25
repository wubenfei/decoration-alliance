package com.ours.wages.mapper;

import com.ours.entity.Wages;

import java.util.List;

public interface WagesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Wages record);

    int insertSelective(Wages record);

    Wages selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Wages record);

    int updateByPrimaryKey(Wages record);

    List<Wages> getAll();
}