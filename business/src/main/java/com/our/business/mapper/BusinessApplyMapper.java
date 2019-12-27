package com.our.business.mapper;

import com.ours.entity.BusinessApply;

import java.util.List;

public interface BusinessApplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BusinessApply record);

    int insertSelective(BusinessApply record);

    BusinessApply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BusinessApply record);

    int updateByPrimaryKey(BusinessApply record);

    List<BusinessApply> selectAll();

    int updateByApplyNumber(String applyNumber, String applyStatus);

    BusinessApply getByApplyNumber(String applyNumber);
}