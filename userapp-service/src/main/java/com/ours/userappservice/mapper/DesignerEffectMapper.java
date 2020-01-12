package com.ours.userappservice.mapper;

import com.ours.entity.DesignerEffect;

import java.util.List;
import java.util.Map;

public interface DesignerEffectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DesignerEffect record);

    int insertSelective(DesignerEffect record);

    DesignerEffect selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DesignerEffect record);

    int updateByPrimaryKey(DesignerEffect record);

    List<Map<String, Object>> getDesignerEffects();
}