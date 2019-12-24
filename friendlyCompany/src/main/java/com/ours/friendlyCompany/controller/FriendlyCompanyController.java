package com.ours.friendlyCompany.controller;

import com.ours.friendlyCompany.dao.FriendlycompanyMapper;
import com.ours.friendlyCompany.entity.DecorationCompany;
import com.ours.friendlyCompany.service.FriendlycompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class FriendlyCompanyController {
    @Autowired
    private FriendlycompanyService fcm;

    //@Cacheable(cacheNames="getFriendlyCompanyKind")
    @GetMapping("/getFriendlyCompanyKind")
    public List<Map<String, Object>> getFriendlyCompanyKind(HttpServletResponse response) {

        //头
        //头
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,Access-Token");
        response.setHeader("Access-Control-Expose-Headers", "*");
        return fcm.queryAllValue();
    }

    //创建新的装修团队
    @RequestMapping("/creatDecorationCompany")
    public String creatDecorationCompany(String friendly_company_kind,
                                         String company_name,
                                         String company_address,
                                         String company_phone,
                                         String company_rephone,
                                         String company_idcard,
                                         String company_idname,
                                         Date intime
    ) {

        System.out.println(intime);
        if (friendly_company_kind.equals("装修团队")) {
            //插入数据
            DecorationCompany decorationCompany = new DecorationCompany();
            decorationCompany.setCompanyName(company_name);
            decorationCompany.setCompanyAddress(company_address);
            decorationCompany.setCompanyPhone(company_phone);
            decorationCompany.setCompanyRephone(company_rephone);
            decorationCompany.setCompanyIdcard(company_idcard);
            decorationCompany.setCompanyIdname(company_idname);
            decorationCompany.setCompanyIntime(intime);
            int i = fcm.insertAcompany(decorationCompany);
            return i + "";
        } else {
            return "请选择入驻团队类型!";
        }
    }
}
