package com.our.business.service;

import com.ours.entity.BusinessApply;

import java.util.List;

public interface BusinessApplyService{


    int deleteByPrimaryKey(Integer id);

    int insert(BusinessApply record);

    int insertSelective(BusinessApply record);

    BusinessApply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BusinessApply record);

    int updateByPrimaryKey(BusinessApply record);
//以下为自定义方法
    List<BusinessApply> selectAll(String status);

    int updateByApplyNumber(String applyNumber, String applyStatus);

    BusinessApply getByApplyNumber(String applyNumber);
}
