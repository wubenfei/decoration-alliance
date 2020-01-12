package com.ours.userappservice.controller;

import com.ours.entity.*;
import com.ours.userappservice.controller.from.ContractFrom;
import com.ours.userappservice.controller.from.DesignerFrom;
import com.ours.userappservice.mapper.DesignerMapper;
import com.ours.userappservice.mapper.UserDesMapper;
import com.ours.userappservice.mapper.UserMapper;
import com.ours.userappservice.service.ContractService;
import com.ours.userappservice.service.HouseService;
import com.ours.userappservice.service.StepService;
import com.ours.userappservice.utils.EncryptUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class UserAppController {
    @Resource
    private UserMapper userMapper;
    @Resource
    private DesignerMapper designerMapper;
    @Resource
    private UserDesMapper userDesMapper;
    @Resource
    private HouseService houseService;
    @Resource
    private ContractService contractService;

    @Autowired
    private SecurityManager securityManager;
    @Resource
    private StepService stepService;
    //客户登录请求（通过电话号码及密码登录）
    @RequestMapping("userLogin")
    @CrossOrigin
    public Object getUserLogin(String phoneNumber, String password) {
        System.out.println(phoneNumber);
        System.out.println(password);
        System.out.println("getUserPhoneAndPassword请求进来了");

        System.out.println("登录请求参数为：电话：" + phoneNumber + "，密码：" + password);
        //获取subject对象
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        //将密码加密
        String pass = EncryptUtil.encrypt(password);
        //创建Token对象
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(phoneNumber, pass);
        try {
            subject.login(usernamePasswordToken);
        } catch (AuthenticationException e) {
            HashMap<Object, Object> map = new HashMap<>();
            map.put("status", "AuthenticationException");
            return map;
        } catch (Exception e) {
            System.out.println("未知错误！");
            HashMap<String, Object> map = new HashMap<>();
            map.put("status", "Exception");
            return map;
        }
        Object principal = subject.getPrincipal();
        User user = (User) principal;
        System.out.println("查询用户为：" + user);
        Map<Object, Object> map = new HashMap<>();
        map.put("status", "success");
        map.put("user", user);
        return map;
    }
    //个人中心获取用户信息（填充用户昵称及头像）
    @RequestMapping("getUser")
    @CrossOrigin
    public User getUser(String phoneNumber) {
        System.out.println("getUser请求进来了");
        System.out.println("phoneNumber:" + phoneNumber);
        User user = userMapper.selectByPhone(phoneNumber);
        System.out.println("当前登录的用户信息为：" + user);
        return user;
    }
    //个人中心修改用户昵称失去焦点后修改数据库用户名
    @RequestMapping("updateUserName")
    @CrossOrigin
    public User updateUserName(Integer userId, String username) {
        System.out.println("updateUserName请求进来了");
        System.out.println("用户id为：" + userId);
        System.out.println("用户名要修改Wie为：" + username);
        userMapper.updateByUserIdAndName(userId, username);
        User user = userMapper.selectByPrimaryKey(userId);
        return user;
    }
    //首页初始化时候获取设计的信息（设计师头像，设计师名字，设计师作品数）
    @RequestMapping("getDesigner")
    @CrossOrigin
    public List<DesignerFrom> getDesigner() {
        System.out.println("getDesigner请求进来了");
        List<Designer> designers = designerMapper.selectAllDesigner();
        List<DesignerFrom> designerFroms = new ArrayList<>();
        for (int i = 0; i < designers.size(); i++) {
            //获得每一个设计师的id
            Designer designer = designers.get(i);
            Integer desId = designer.getId();
            //统计出每个设计师已经完成的成功案例数
            int countSuccess = userDesMapper.countSuccess(desId, 2);
            DesignerFrom designerFrom = new DesignerFrom(i, designer.getId(), designer.getUrl(), designer.getDesignerName(), countSuccess);
            designerFroms.add(designerFrom);
        }
        return designerFroms;
    }
    //用户编辑房屋地址（点击保存时候将用户的房屋信息存到数据库）
    @RequestMapping("addHouse")
    @CrossOrigin
    public House addHouse(String addres , Double houseHeight , Double houseArea ,String houseType,Integer userId){
        System.out.println("addHouse请求进来了");
        System.out.println("addres:"+addres);
        System.out.println("houseHeight:"+houseHeight);
        System.out.println("houseArea:"+houseArea);
        System.out.println("houseType:"+houseType);
        System.out.println("userId:"+userId);

        House house = new House();
        house.setHouseAddress(addres);
        house.setHouseHeight(houseHeight);
        house.setHouseArea(houseArea);
        house.setHouseType(houseType);
        house.setUserId(userId);
        houseService.insert(house);
        Integer id = house.getId();
        House addHouse = houseService.selectByPrimaryKey(id);
        return addHouse;
    }
    //keep.vue页面初始化的时候通过用户id查询该用户所有的合同信息（一个用户可能有多个合同）
    @RequestMapping("getContracts")
    public List<ContractFrom> getContracts(Integer userId){
        System.out.println("getContracts请求进来了");
        System.out.println("传递的参数为："+userId);
        List<Contract> contractList = contractService.getContractList(userId);
        System.out.println("查询的用户合同信息："+contractList);

        ArrayList<ContractFrom> contractFroms = new ArrayList<>();
        for (int i = 0; i <contractList.size() ; i++) {
            //获取单份合同信息
            Contract contract = contractList.get(i);
            Integer houseid = contract.getContractHouseid();
            House house = houseService.selectByPrimaryKey(houseid);

            ContractFrom contractFrom = new ContractFrom();
            contractFrom.setAddress(house.getHouseAddress());
            contractFrom.setContractNumber(contract.getContractNumber());
            contractFrom.setContractStatus(contract.getContractStatus());
            contractFrom.setContractType(contract.getContractType());
            contractFroms.add(contractFrom);
        }
        return contractFroms;
    }
    //获取点击的合同的进度信息
    @RequestMapping("getStep")
    public Map<String, Object> getStep(String contractNumber){
        System.out.println("getStep请求进来了");
        System.out.println("参数为："+contractNumber);
        Contract contract = contractService.selectByContractNumber(contractNumber);
        Integer id = contract.getId();
        Map<String, Object> maps = stepService.selectByContractId(id);
        Map<String, Object> hashMap = new HashMap<>();
        System.out.println("合同进度详情："+maps);
        int i = 0;
        int j = 0 ;
        if (maps!=null){
            Set<Map.Entry<String, Object>> set = maps.entrySet();
            Iterator<Map.Entry<String, Object>> iterator = set.iterator();
            while(iterator.hasNext()){
                Map.Entry<String, Object> next = iterator.next();
                String key = next.getKey();
                if (key.contains("img")){
                    String value = (String)next.getValue();
                    if (value!=null&&value.trim().length()!=0){
                        i++;
                        String[] split = value.split(",");
                        maps.put(key,split);
                        for (int k = 0; k <split.length ; k++) {
                            System.out.println(key+"图片为："+split[k]);
                        }
                    }
                }
                if(key.contains("time")){
                    Date value = (Date) next.getValue();
                    if (value!=null){
                        j++;
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        String format = simpleDateFormat.format(value);
                        maps.put("time"+j,format);
                    }
                }
            }
            hashMap=maps;
        }
        hashMap.put("nav",i);
        Set<Map.Entry<String, Object>> entries = hashMap.entrySet();
        Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Object> next = iterator.next();
            System.out.println(next.getKey()+"========="+next.getValue());
        }
        return hashMap;
    }
}
