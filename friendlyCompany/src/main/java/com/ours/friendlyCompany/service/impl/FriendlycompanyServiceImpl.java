package com.ours.friendlyCompany.service.impl;

import com.ours.friendlyCompany.dao.DecorationCompanyMapper;
import com.ours.friendlyCompany.dao.FriendlycompanyMapper;
import com.ours.friendlyCompany.entity.DecorationCompany;
import com.ours.friendlyCompany.service.FriendlycompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FriendlycompanyServiceImpl implements FriendlycompanyService {
    @Autowired
    private FriendlycompanyMapper friendlycompanyMapper;
    @Autowired
    private DecorationCompanyMapper decorationCompanyMapper;

    @Override
    public List<Map<String, Object>> queryAllValue() {
        return friendlycompanyMapper.queryAllValue();
    }

    @Override
    public int insertAcompany(DecorationCompany decorationCompany) {
        //return friendlycompanyMapper.insertBySome(company_name,company_address,company_phone,company_rephone,company_idcard,company_idname,intime);
        return decorationCompanyMapper.insertSelective(decorationCompany);
    }
}
