package com.ours.userapp.mapper;


import com.ours.entity.DecorationCompany;

public interface DecorationCompanyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DecorationCompany record);

    int insertSelective(DecorationCompany record);

    DecorationCompany selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DecorationCompany record);

    int updateByPrimaryKey(DecorationCompany record);

    DecorationCompany selectByTelAndPassword(String tel, String password);

    DecorationCompany selectByTel(String tel);
}