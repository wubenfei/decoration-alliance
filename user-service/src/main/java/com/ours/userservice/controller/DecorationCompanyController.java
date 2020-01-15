package com.ours.userservice.controller;

import com.ours.entity.DecorationCompany;
import com.ours.userservice.controller.from.DecorationFrom;
import com.ours.userservice.mapper.DecorationCompanyMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DecorationCompanyController {
    @Resource
    private DecorationCompanyMapper decorationCompanyMapper;

    @RequestMapping("getDecorationCompany")
    @CrossOrigin
    public List<DecorationFrom> getDecorationCompany() {
        //获取所有的装修团队信息
        List<DecorationCompany> allDecorationCompany = decorationCompanyMapper.getAllDecorationCompany();
        //创建一个集合用于存需要展示的装修团队信息
        List<DecorationFrom> decorationFromList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //遍历装修团队对象集合，将需要展示的信息存入decorationFromList中
        if (allDecorationCompany.size() >= 0) {
            for (int i = 0; i < allDecorationCompany.size(); i++) {
                DecorationCompany decorationCompany = allDecorationCompany.get(i);
                String inTime = sdf.format(decorationCompany.getCompanyIntime());
                DecorationFrom decorationFrom = new DecorationFrom(decorationCompany.getId(), decorationCompany.getCompanyName(), decorationCompany.getCompanyAddress(), inTime, decorationCompany.getCompanyPhone(), decorationCompany.getCompanyIdname(), decorationCompany.getCompanyStatus());
                decorationFromList.add(decorationFrom);
            }
        }
        System.out.println("所有需要展示在前段的装修团队信息" + decorationFromList);
        return decorationFromList;
    }

    @RequestMapping("updateDecorationCompany")
    @CrossOrigin
    public DecorationFrom updateDecorationCompany(int id, String statu) {
        System.out.println(id);
        System.out.println(statu);
        //修改装修团队状态
        decorationCompanyMapper.updateDecorationCompanyStatus(statu, id);
        //获取修改后的装修团队信息
        DecorationCompany decorationCompany = decorationCompanyMapper.selectByPrimaryKey(id);
        System.out.println("修改后的装修团队信息" + decorationCompany);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String inTime = sdf.format(decorationCompany.getCompanyIntime());
        DecorationFrom decorationFrom = new DecorationFrom(decorationCompany.getId(), decorationCompany.getCompanyName(), decorationCompany.getCompanyAddress(), inTime, decorationCompany.getCompanyPhone(), decorationCompany.getCompanyIdname(), decorationCompany.getCompanyStatus());
        //修改后要展示的信息
        System.out.println("修改后要展示的装修团队信息" + decorationFrom);
        return decorationFrom;
    }
}
