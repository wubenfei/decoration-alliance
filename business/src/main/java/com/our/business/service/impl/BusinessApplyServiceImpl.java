package com.our.business.service.impl;

import com.our.business.mapper.BusinessApplyMapper;
import com.our.business.service.BusinessApplyService;
import com.ours.entity.BusinessApply;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BusinessApplyServiceImpl implements BusinessApplyService{

    @Resource
    private BusinessApplyMapper businessApplyMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return businessApplyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(BusinessApply record) {
        return businessApplyMapper.insert(record);
    }

    @Override
    public int insertSelective(BusinessApply record) {
        return businessApplyMapper.insertSelective(record);
    }

    @Override
    public BusinessApply selectByPrimaryKey(Integer id) {
        return businessApplyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BusinessApply record) {
        return businessApplyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BusinessApply record) {
        return businessApplyMapper.updateByPrimaryKey(record);
    }

    /**
     * 自定义方法
     * @return
     * @param status
     */
    @Override
    public List<BusinessApply> selectAll(String status) {
        List<BusinessApply> list = businessApplyMapper.selectAll(status);
        return list;
    }

    @Override
    public int updateByApplyNumber(String applyNumber, String applyStatus) {
//        System.out.println("进行到这里了吗1"+applyNumber+applyStatus);
        int i = businessApplyMapper.updateByApplyNumber(applyNumber,applyStatus);
        return i;
    }

    @Override
    public BusinessApply getByApplyNumber(String applyNumber) {
        BusinessApply businessApply = businessApplyMapper.getByApplyNumber(applyNumber);
//        System.out.println("数据拿到了11111："+businessApply);

        return businessApply;
    }

}
