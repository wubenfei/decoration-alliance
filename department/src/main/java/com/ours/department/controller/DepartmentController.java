package com.ours.department.controller;

import com.ours.department.service.DepartmentService;
import com.ours.entity.DepForm;
import com.ours.entity.Department;
import com.ours.entity.Staff;
import com.ours.staff.controller.StaffController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin
@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    // 调用Staffcontroller中的查询员工方法
    private StaffController staffController = new StaffController();
    @Resource
    private RestTemplate restTemplate;
    /**
     * 获取部门列表
     * @return List<Department>
     */
    @GetMapping("getDep")
    public List<Department> getDep(){
        List<Department> deps = departmentService.selectDeps();
        System.out.println(deps);
        return deps;
    }

    /**
     * 获取用户选择的部门的详细信息
     * @param depId
     * @return DepForm
     */
    @GetMapping("getDetail")
    public DepForm getDepDetail(Integer depId,
                                HttpSession session,
                                HttpServletRequest request
                               ){
        System.out.println("请求进入getDepDetail："+depId);
        // 查询部门
        Department department = departmentService.selectByPrimaryKey(depId);
        // 查询部门成员
        System.out.println("staffController:"+staffController);
        MultiValueMap map = new LinkedMultiValueMap<String,Object>();
        map.add("depId", depId+"");
        System.out.println("即将调用postRequest：");
        List<Staff> staffs = (List<Staff>) postRequest(request, session, map, "http://staff/dep/getStaff");
        // 创建对象并存值
        DepForm depForm = new DepForm();
        depForm.setDepId(department.getDepId());
        depForm.setDepName(department.getDepName());
        depForm.setHeadCount(staffs.size());
        depForm.setStaffs(staffs);
        return depForm;
    }
    // 封装转发携带cookie
    public Object postRequest(HttpServletRequest request,
                              HttpSession session,
                              MultiValueMap<String, Object> map,
                              String url) {

        Cookie[] cookies = request.getCookies();
        String SESSION = null;
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie :
                    cookies) {
                if ("SESSION".equals(cookie.getName())) {
                    SESSION = cookie.getValue();// 加密后的
                    break;
                }
            }
        }
        System.out.println("转发后的SESSION：" + SESSION);
        //创建Http头信息对象
        HttpHeaders headers = new HttpHeaders();
        //创建集合保存cookie信息
        List<String> cookiesList = new ArrayList<String>();
        //将session键保存到cookie中
        cookiesList.add("SESSION=" + SESSION + ";Path=/; HttpOnly");
        //将cookie存入头部
        headers.put(HttpHeaders.COOKIE, cookiesList);
        //请求的参数(没有参数）
//        MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
//        map.add("id",id);
        //封装参数和cookie
        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<MultiValueMap<String, Object>>(map, headers);

        System.out.println("用户服务中的sessionId：" + session.getId());
//        Staff forObject =   restTemplate.getForObject(url, Staff.class);
//        Staff forObject = restTemplate.getForObject("http://phone-service/get", Staff.class);
        List<Staff> forObject = restTemplate.postForObject(url, httpEntity, List.class);
        System.out.println("forObject:"+forObject);
        return forObject;
    }
}
