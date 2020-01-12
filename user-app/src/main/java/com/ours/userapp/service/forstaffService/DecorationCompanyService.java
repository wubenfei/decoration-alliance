package com.ours.userapp.service.forstaffService;

import com.ours.entity.DecorationCompany;

public interface DecorationCompanyService{


    int deleteByPrimaryKey(Integer id);

    int insert(DecorationCompany record);

    int insertSelective(DecorationCompany record);

    DecorationCompany selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DecorationCompany record);

    int updateByPrimaryKey(DecorationCompany record);

    DecorationCompany selectByTel(String tel);

}
