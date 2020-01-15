package com.our.business.controller;

import com.our.business.service.BusinessApplyService;
import com.ours.entity.BusinessApply;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
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
    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * 获取指定状态的消息：已读，未读，删除，已处理，未处理
     * @param status
     * @return
     */
    @RequestMapping("getBusinessApply")
    public List<BusinessApply> getBA(String status){
        System.out.println("获取消息："+status);
        List<BusinessApply> list =  businessApplyService.selectAll(status);
        System.out.println(list);
        return list;
    }
    /**
     * 处理未读消息转换为已读消息
     * @return
     */
    @RequestMapping("handleStatus")
    public String handleStatus(String applyNumber, String applyStatus){
//        System.out.println("进行到这里了吗"+applyNumber+applyStatus);
        int i = businessApplyService.updateByApplyNumber(applyNumber,applyStatus);
        rabbitTemplate.convertAndSend("apply",null,"1");
        // 重新查询新的未读消息并返回
        return "forward:getBusinessApply";
    }
    @RequestMapping("getByApplyNumber")
    public BusinessApply getByApplyNumber(String applyNumber){
//        System.out.println("进入getByApplyNumber："+applyNumber);
        BusinessApply businessApply = businessApplyService.getByApplyNumber(applyNumber);
        rabbitTemplate.convertAndSend("apply",null,"1");
        return businessApply;
    }
}
