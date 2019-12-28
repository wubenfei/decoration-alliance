package com.our.business.controller;

import com.our.business.service.BusinessApplyService;
import com.ours.entity.BusinessApply;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Controller
@CrossOrigin
@RestController

public class BusibessController {
    @Resource
    private BusinessApplyService businessApplyService;
    @RequestMapping("getBusinessApply")
    public List<BusinessApply> getBA(){
        List<BusinessApply> list =  businessApplyService.selectAll();
//        System.out.println(list);
        return list;
    }
    /**
     * 处理未读消息转换为已读消息
     * @return
     */
    @RequestMapping("handleStatus")
    public String handleStatus(String applyNumber, String applyStatus){
        System.out.println("进行到这里了吗"+applyNumber+applyStatus);
        int i = businessApplyService.updateByApplyNumber(applyNumber,applyStatus);
        // 重新查询新的未读消息并返回
        return "forward:getBusinessApply";
    }
    @RequestMapping("getByApplyNumber")
    public BusinessApply getByApplyNumber(String applyNumber){
        System.out.println("进入getByApplyNumber："+applyNumber);
        BusinessApply businessApply = businessApplyService.getByApplyNumber(applyNumber);
        return businessApply;
    }
}
