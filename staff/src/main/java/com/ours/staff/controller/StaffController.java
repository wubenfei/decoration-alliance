package com.ours.staff.controller;

import com.ours.entity.Staff;
import com.ours.staff.mapper.StaffMapper;
import com.ours.staff.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
// 解决跨域问题
@CrossOrigin
@Controller
public class StaffController {
    @Resource
    private StaffService staffService;
    @Autowired
    private StaffMapper staffMapper;
    /**
     * 用于查询部门员工
     * Auth:MrW
     */
    @ResponseBody
    @RequestMapping("dep/getStaff")
    public List<Staff> selectDepMembersByDepId(String depId){
        System.out.println("selectDepMembersByDepId被调用了:"+depId);
        System.out.println("测试数据");
        System.out.println(staffMapper);
//        List<Staff> staffs = staffService.selectDepMembersByDepId(depId);
        List<Staff> staffs = staffMapper.selectDepMembersByDepId(depId);
        System.out.println("staffs.size()"+staffs.size());
        return staffs;
    }
}
