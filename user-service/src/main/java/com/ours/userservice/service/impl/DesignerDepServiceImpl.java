package com.ours.userservice.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.ours.userservice.mapper.DesignerDepMapper;
import com.ours.entity.DesignerDep;
import com.ours.userservice.service.DesignerDepService;

@Service
public class DesignerDepServiceImpl implements DesignerDepService {

    @Resource
    private DesignerDepMapper designerDepMapper;

    @Override
    public int insert(DesignerDep record) {
        return designerDepMapper.insert(record);
    }

    @Override
    public int insertSelective(DesignerDep record) {
        return designerDepMapper.insertSelective(record);
    }

}
