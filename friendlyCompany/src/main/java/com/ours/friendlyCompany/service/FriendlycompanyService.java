package com.ours.friendlyCompany.service;

import com.ours.friendlyCompany.entity.DecorationCompany;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface FriendlycompanyService {
    List<Map<String, Object>> queryAllValue();

    int insertAcompany(DecorationCompany decorationCompany);
}
