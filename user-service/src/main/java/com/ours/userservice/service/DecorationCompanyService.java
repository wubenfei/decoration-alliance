package com.ours.userservice.service;

import com.ours.entity.DecorationCompany;

import java.util.List;

public interface DecorationCompanyService {


    int deleteByPrimaryKey(Integer id);

    int insert(DecorationCompany record);

    int insertSelective(DecorationCompany record);

    DecorationCompany selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DecorationCompany record);

    int updateByPrimaryKey(DecorationCompany record);

    List<DecorationCompany> getAllDecorationCompany();

    int updateDecorationCompanyStatus(String status, Integer id);

}
