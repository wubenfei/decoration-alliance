package com.ours.userapp.controller;

import com.ours.userapp.service.forstaffService.Forstaff_getUserDesListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

/*
获取设计师列表
 */
@CrossOrigin
@RestController
public class Forstaff_getUserDesListController {
    @Autowired
    private Forstaff_getUserDesListService fguds;

    /**
     * 获得用户的设计师列表
     * @param user_id 用户id
     * @return
     */
    @GetMapping("/getUserDesList")
    public List<Map<String,Object>> getUserDesList(Integer user_id){
        //得到设计师列表
        List<Integer> dessId=fguds.getDessId(user_id);
        System.out.println("该客户设计师列表的id为"+dessId);
        //按照用户id得到的设计师列表及其信息
        List<Map<String,Object>> mapList= fguds.queryDesList(user_id);
        System.out.println("该客户设计师列表详细信息为"+mapList);
        //拿到usertitle
        String usertitle=fguds.getUsertitle();
        System.out.println("usertitle:"+usertitle);
        //拿到designertitle
        String designertitle=fguds.getDesignertitle();
        System.out.println("designertitle:"+designertitle);
        //按客户id查询最后一条聊天信息
        getLastChatMess(user_id, dessId, mapList, usertitle, designertitle);
        return mapList;
    }

    /**
     * 获得用户的设计师列表
     * @param userId 用户id
     * @return
     */
    @GetMapping("/getUserDesListRe")
    public List<Map<String,Object>> getUserDesListRe(Integer userId,String username){
        //得到设计师id列表
        List<Integer> usersId=fguds.getUsersIdRe(userId,username);
        List<Map<String,Object>> mapList= fguds.queryUserListRe(userId,username);
        //拿到usertitle
        String usertitle=fguds.getUsertitle();
        System.out.println("usertitle:"+usertitle);
        //拿到designertitle
        String designertitle=fguds.getDesignertitle();
        System.out.println("designertitle:"+designertitle);
        //按客户id查询最后一条聊天信息
        getLastChatMess(userId, usersId, mapList, usertitle, designertitle);
        System.out.println(mapList);
        return mapList;
    }


    /**
     * 按客户id查询最后一条信息+设计师姓名+用户姓名
     * @param user_id 设计师id
     * @param dessId 设计师id
     * @param mapList 数据map
     * @param usertitle 用户识别头文字
     * @param designertitle 设计师识别头文字
     */
    private void getLastChatMess(Integer user_id, List<Integer> dessId, List<Map<String, Object>> mapList, String usertitle, String designertitle) {
        //查询到该用户的设计师列表不为空
        if (dessId.size()!=0){
            //遍历设计师集合,i为下标,同样查询语句,所以可对应到相同mapList下标
            for (int i = 0; i<dessId.size(); i++) {
                System.out.println("designertitle+i:"+designertitle+dessId.get(i));
                System.out.println("usertitle+user_id:"+usertitle+user_id);
                //查询设计师与用户最后一条聊天信息
                Map<String,Object> m=fguds.queryLastChat(designertitle+dessId.get(i),usertitle+user_id);
                //存在最后一条聊天信息
                if (m!=null){
                    //不为空则有聊天信息,取查询未读,传入当前下标的user_id+title和设计师的id+title
                    Integer num=fguds.queryNumNotstatus(designertitle+dessId.get(i),usertitle+user_id);
                    //存入未读条数
                    mapList.get(i).put("NumNotstatus",num);
                    //遍历
                    Set<Map.Entry<String, Object>> set = m.entrySet();
                    Iterator<Map.Entry<String, Object>> iterator = set.iterator();
                    while(iterator.hasNext()){
                        Map.Entry<String, Object> next = iterator.next();
                        String key = next.getKey();
                        Object value = next.getValue();
                        //拿到发送时间并修改格式
                        if (key.equals("send_time")){
                            value=new SimpleDateFormat("MM-dd HH:mm").format((Date)value);
                        }
                        System.out.println("键:"+key);
                        System.out.println("值:"+value);
                        System.out.println("i:"+i);
                        System.out.println("mapList长度:"+mapList.size());
                        //按下标放入数据集合
                        mapList.get(i).put(key,value);
                    }
                }else {
                    //不存在聊天数据不做处理直接继续
                    continue;
                }
            }
        }
    }

    @PostMapping("/changeIn")
    public Integer changeIn(Integer id,Integer in){
        //按照id更改in显示状态
        System.out.println("id:"+id);
        System.out.println("in:"+in);
        int i=-1;
        if (in==1){
            i= fguds.changNotIn(id);
        }else {
            i= fguds.changIn(id);
        }
       return i;
    }

    @GetMapping("/queryOneUser")
    public List<Map<String, Object>> queryOneUser(String user_name, Integer des_id) {
        System.out.println("搜索:" + user_name + ";des_id:" + des_id);
        //对于同一设计师(des_id),同一个名字可能多个结果
        List<Map<String, Object>> users = fguds.queryOneUser(user_name, des_id);
        //得到客户列表
        List<Integer> usersId = fguds.getUsersIdByName(user_name, des_id);
        //拿到usertitle
        String usertitle = fguds.getUsertitle();
        System.out.println("usertitle:" + usertitle);
        //拿到designertitle
        String designertitle = fguds.getDesignertitle();
        System.out.println("designertitle:" + designertitle);
        getLastChatMess(des_id, usersId, users, usertitle, designertitle);
        return users;
    }

    @GetMapping("/getKeyword")
    public Map<String,List<List<String>>> getKeyword(Integer userId,String keyword){
        //获得destitle
        //拿到designertitle
        String designertitle=fguds.getDesignertitle();
        System.out.println("designertitle:"+designertitle);
        //查询用户的所有设计师
        List<String> lis = fguds.getAllUsername(userId, keyword);
        List<List<String>> lists = new ArrayList<>();
        if (!lis.isEmpty()){
            for (String s:lis
            ) {
                List<String> lists0 = new ArrayList<>();
                lists0.add(s);
                lists.add(lists0);
            }
        }
        Map<String, List<List<String>>> listHashMap = new HashMap<>();
        listHashMap.put("result",lists);
        return listHashMap;
    }
}
