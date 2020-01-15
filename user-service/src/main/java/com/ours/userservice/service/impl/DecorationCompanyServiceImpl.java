package com.ours.userservice.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.ours.userservice.mapper.DecorationCompanyMapper;
import com.ours.entity.DecorationCompany;
import com.ours.userservice.service.DecorationCompanyService;

import java.util.List;

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
    public List<DecorationCompany> getAllDecorationCompany() {
        return decorationCompanyMapper.getAllDecorationCompany();
    }

    @Override
    public int updateDecorationCompanyStatus(String status, Integer id) {
        return decorationCompanyMapper.updateDecorationCompanyStatus(status, id);
    }

}
