package com.ours.userapp.service.forstaffService.impl;

import com.ours.entity.DecorationCompany;
import com.ours.userapp.mapper.DecorationCompanyMapper;
import com.ours.userapp.service.forstaffService.DecorationCompanyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DecorationCompanyServiceImpl implements DecorationCompanyService {

    @Resource
    private DecorationCompanyMapper decorationCompanyMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return decorationCompanyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DecorationCompany record) {
        return decorationCompanyMapper.insert(record);
    }

    @Override
    public int insertSelective(DecorationCompany record) {
        return decorationCompanyMapper.insertSelective(record);
    }

    @Override
    public DecorationCompany selectByPrimaryKey(Integer id) {
        return decorationCompanyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(DecorationCompany record) {
        return decorationCompanyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(DecorationCompany record) {
        return decorationCompanyMapper.updateByPrimaryKey(record);
    }

    @Override
    public DecorationCompany selectByTel(String tel) {
        System.out.println("impl中开始执行查询");
        DecorationCompany decorationCompany = decorationCompanyMapper.selectByTel(tel);
        System.out.println("impl中的结果："+decorationCompany);
        return decorationCompany;
    }

}
