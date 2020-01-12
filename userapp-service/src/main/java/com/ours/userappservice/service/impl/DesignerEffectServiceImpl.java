package com.ours.userappservice.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.ours.userappservice.mapper.DesignerEffectMapper;
import com.ours.entity.DesignerEffect;
import com.ours.userappservice.service.DesignerEffectService;

import java.util.List;
import java.util.Map;

@Service
public class DesignerEffectServiceImpl implements DesignerEffectService {

    @Resource
    private DesignerEffectMapper designerEffectMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return designerEffectMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DesignerEffect record) {
        return designerEffectMapper.insert(record);
    }

    @Override
    public int insertSelective(DesignerEffect record) {
        return designerEffectMapper.insertSelective(record);
    }

    @Override
    public DesignerEffect selectByPrimaryKey(Integer id) {
        return designerEffectMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(DesignerEffect record) {
        return designerEffectMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(DesignerEffect record) {
        return designerEffectMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map<String, Object>> getDesignerEffects() {
        return designerEffectMapper.getDesignerEffects();
    }


}
