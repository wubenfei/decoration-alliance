package com.ours.friendlyCompany.service;

import com.ours.friendlyCompany.entity.DecorationCompany;
import com.ours.friendlyCompany.entity.Designer;

import java.util.List;
import java.util.Map;

public interface FriendlycompanyService {
    List<Map<String, Object>> queryAllValue();

    int insertAcompany(DecorationCompany decorationCompany);

    /**
     * Auth:MrW
     * @param tel
     * @param password
     * @return
     */
    DecorationCompany selectByTelAndPassword(String tel, String password);

    Designer selectDesignerByTelAndPassword(String tel, String password);
}
