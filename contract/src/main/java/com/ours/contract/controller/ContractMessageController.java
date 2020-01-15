package com.ours.contract.controller;

import com.ours.contract.entity.*;
import com.ours.contract.service.ContractMessageService.ContractMessageService;
import com.ours.contract.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
@CrossOrigin
public class ContractMessageController {
    @Autowired
    private ContractMessageService cms;

    /**
     * 获取进行中|异常的合同,用于展示
     * 有redis缓存
     *
     * @param response
     * @param currentPage1 当前页码
     * @param pageSize     每页条数
     * @return
     */
    @Cacheable(cacheNames = "getContractMessage", key = "#currentPage1")
    @GetMapping("/getContractMessage")
    public Datalist getControllerMessage(HttpServletResponse response, int currentPage1, int pageSize) {
        System.out.println("当前页码+++++++++++:" + currentPage1);
        //返回参数
        Datalist datalist = new Datalist();
        int from = (currentPage1 - 1) * pageSize;
        //获取总条数
        int contractMessageCount = cms.queryContractMessageAll();
        //查询进行中|异常的合同
        List<Map<String, Object>> contractMessage = cms.queryContractMessage(from, pageSize);
        System.out.println("获取进行中|异常的合同:" + contractMessage.size());
        if (contractMessage.size() == 0) {
            return datalist;
        }
        //处理时间数据
        forTimeAndName(contractMessage);
        //头
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-cache");
        //参数
        datalist.setForlist(contractMessage);
        datalist.setPageTotal(contractMessageCount);
        return datalist;
    }

    /**
     * 处理时间等数据
     * @param contractMessage 传入合同数据
     */
    private void forTimeAndName(List<Map<String, Object>> contractMessage) {
        if (contractMessage.size() != 0) {
            for (int i = 0; i < contractMessage.size(); i++) {
                Map map = (Map) contractMessage.get(i);
                Date due_time = (Date) map.get("due_time");
                Date signing_time = (Date) map.get("signing_time");
                //获取甲方id
                int user_id = (int) map.get("user_id");
                //获取甲方姓名
                User user = cms.getUsername(user_id);
                System.out.println("user+++++++++++++++++++++++++++");
                System.out.println(user);
                System.out.println("map+++++++++++++++++++++++++++");
                System.out.println(map);
                map.put("user_name", user.getUsername());
                //时间格式转字符串
                String ymdMhs = DateUtils.getYmdMhs(due_time);
                String ymdMhs1 = DateUtils.getYmdMhs(signing_time);
                map.put("due_time", ymdMhs);
                map.put("signing_time", ymdMhs1);
                //获取平台人员id
                int staff_id = (int) map.get("staff_id");
                //查找平台人员
                Staff staff = cms.getStaff(staff_id);
                map.put("staff_name", staff.getStaffName());
                map.put("staff_phone", (String) map.get("staff_phone"));
                if (((String) map.get("contract_type")).equals("设计合同")) {
                    //获取乙方设计师id
                    int designer_id = (int) map.get("designer_id");
                    System.out.println("设计师id:" + designer_id);
                    //获取设计师乙方姓名
                    Designer designer = cms.getDesignername(designer_id);
                    System.out.println(designer.toString());
                    map.put("other_name", designer.getDesignerName());
                    map.put("other_idcard", (String) map.get("designer_idcard"));
                    map.put("other_phone", (String) map.get("designer_phone"));
                } else {
                    //获取乙方装修公司id
                    int decoration_company_id = (int) map.get("decoration_company_id");
                    //获取装修公司姓名
                    DecorationCompany decorationCompany = cms.getDecorationCompany(decoration_company_id);
                    map.put("other_name", decorationCompany.getCompanyName());
                    map.put("other_idcard", (String) map.get("decoration_company_idcard"));
                    map.put("other_phone", (String) map.get("decoration_company_phone"));
                }
            }
        }
    }

    /**
     * 状态更改
     * 清除所有redis中合同相关缓存
     *
     * @param response
     * @param ids             合同表主键
     * @param contract_status 状态
     * @return
     */
    @CacheEvict(cacheNames = {"getContractMessage", "getContractMessageById"}, allEntries = true)
    @PutMapping("/changeContractStatus")
    public Map<String, Object> changeContracStatus(HttpServletResponse response, int ids, String contract_status) {
        //头
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,Access-Token");
        response.setHeader("Access-Control-Expose-Headers", "*");

        //按合同表主键更改状态
        int i = cms.updateStatusById(ids, contract_status);
        //System.out.println("受影响的i:"+i);
        if (i == 1) {
            Map<String, Object> map = new HashMap<>();
            map.put("mess", i);
            map.put("contract_status", contract_status);
            return map;
        } else {
            Map<String, Object> map = new HashMap<>();
            map.put("mess", 0);
            return map;
        }
    }

    /**
     * 按合同编号搜索
     * 有redis缓存
     *
     * @param response
     * @param num      合同编号
     * @return
     */
    @Cacheable(cacheNames = "getContractMessageById",key = "#num")
    @GetMapping("/getContractMessageById")
    public Datalist getControllerMessageById(HttpServletResponse response, String num) {
        List<Map<String, Object>> listT = cms.queryContractTimeById(num);
        System.out.println("num:" + num);
        //返回参数
        Datalist datalist = new Datalist();
        //时间
        if (listT.size() != 0) {
            for (int i = 0; i < listT.size(); i++) {
                Map map = (Map) listT.get(i);
                Date due_time = (Date) map.get("due_time");
                Date signing_time = (Date) map.get("signing_time");
                //时间格式转字符串
                String ymdMhs = DateUtils.getYmdMhs(due_time);
                String ymdMhs1 = DateUtils.getYmdMhs(signing_time);
                map.put("due_time", ymdMhs);
                map.put("signing_time", ymdMhs1);
            }
        }
        //头
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-cache");
        //参数
        datalist.setForlist(listT);
        datalist.setPageTotal(listT.size());
        return datalist;
    }

    /**
     * 按多条件搜索合同
     *
     * @param response
     * @param checkboxGroup 选择的条件
     * @param text          输入的搜索数据
     * @param currentPage1  当前页码
     * @param pageSize      每页条数
     * @return
     */
    @CacheEvict(cacheNames="getContractMessage",allEntries = true)
    @GetMapping("/getContractMessageByKinds")
    public Datalist getContractMessageByKinds(HttpServletResponse response,
                                              String[] checkboxGroup,
                                              String text,
                                              Integer currentPage1,
                                              Integer pageSize) {
        System.out.println("text:" + text);
        //头
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-cache");
        int from = (currentPage1 - 1) * pageSize;
        //返回参数
        Datalist datalist = new Datalist();
        //将输入数据切割
        String[] strings = text.split("-");
        int clength = checkboxGroup.length;
        int slength = strings.length;
        System.out.println("checkboxGroup.length:" + checkboxGroup.length);
        for (String s : checkboxGroup
        ) {
            System.out.println(s);
        }
        System.out.println("strings.length:" + strings.length);
        for (String s1 : strings
        ) {
            System.out.println(s1);
        }

        if (clength == slength) {
            //字段数和输入数据数匹配,只有字段数据都不为0时才符合
            StringBuilder builder = new StringBuilder();
            StringBuilder builder1 = new StringBuilder();
            //自定义sql
            builder.append("select * from contract where ");
            builder1.append("select count(*) from contract where ");
            for (int i = 0; i < clength - 1; i++) {
                if (strings[i].trim() == "") {
                    //空数据
                    return geWarntDatalist1(datalist);
                }
                builder.append(checkboxGroup[i] + "=");
                builder1.append(checkboxGroup[i] + "=");
                builder.append("\"" + strings[i] + "\" ");
                builder1.append("\"" + strings[i] + "\" ");
                builder.append("and ");
                builder1.append("and ");
            }
            if (strings[clength - 1].trim() == "") {
                //空数据
                return geWarntDatalist1(datalist);
            }
            builder.append(checkboxGroup[clength - 1] + "=");
            builder.append("\"" + strings[clength - 1] + "\" ");
            builder1.append(checkboxGroup[clength - 1] + "=");
            builder1.append("\"" + strings[clength - 1] + "\" ");
            builder.append("limit " + from + "," + pageSize);
            System.out.println(builder.toString());
            System.out.println(builder1.toString());
            //查询
            int i = cms.queryBySql1(builder1.toString());
            List<Map<String, Object>> listT = cms.queryBySql(builder.toString());
            forTimeAndName(listT);
            datalist.setForlist(listT);
            datalist.setPageTotal(i);
            System.out.println("多条件搜索成功");
            return datalist;

        } else if (clength != slength) {
            //字段数和输入数据数不匹配
            if (clength == 0) {
                if (strings.length == 1 & (strings[0] == null || strings[0].trim() == "")) {
                    //什么都没选,什么都没输入,查询所有合同数据
                    List<Map<String, Object>> listAllPage = cms.queryAll(from, pageSize);
                    forTimeAndName(listAllPage);
                    datalist.setForlist(listAllPage);
                    //查询所有页码数
                    int i = cms.queryAllCount();
                    datalist.setPageTotal(i);
                    return datalist;
                } else {
                    //不匹配
                    return geWarntDatalist(datalist);
                }
            } else {
                //不匹配
                return geWarntDatalist(datalist);
            }
        }
        return datalist;

    }

    //搜索字段和数据不匹配时候的处理
    private Datalist geWarntDatalist(Datalist datalist) {
        Map<String, Object> map = new HashMap<>();
        map.put("warnings", "搜索字段量与数据量不匹配 !");
        List list = new ArrayList();
        list.add(map);
        datalist.setForlist(list);
        datalist.setPageTotal(0);
        return datalist;
    }

    //搜索数据为空的处理
    private Datalist geWarntDatalist1(Datalist datalist) {
        Map<String, Object> map = new HashMap<>();
        map.put("warnings", "请勿在选择搜索条件后输入空数据 !");
        List list = new ArrayList();
        list.add(map);
        datalist.setForlist(list);
        datalist.setPageTotal(0);
        return datalist;
    }

}
