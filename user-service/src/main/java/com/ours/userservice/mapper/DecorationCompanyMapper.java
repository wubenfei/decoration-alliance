package com.ours.userservice.mapper;

import com.ours.entity.DecorationCompany;

import java.util.List;

public interface DecorationCompanyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DecorationCompany record);

    int insertSelective(DecorationCompany record);

    DecorationCompany selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DecorationCompany record);

    int updateByPrimaryKey(DecorationCompany record);

    List<DecorationCompany> getAllDecorationCompany();

    int updateDecorationCompanyStatus(String status, Integer id);
}