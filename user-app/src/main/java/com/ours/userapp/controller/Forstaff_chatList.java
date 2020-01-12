package com.ours.userapp.controller;

import com.ours.userapp.service.forstaffService.Forstaff_chatListService;
import com.ours.userapp.service.forstaffService.Forstaff_getUserDesListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@CrossOrigin
public class Forstaff_chatList {
    @Autowired
    private Forstaff_getUserDesListService fguds;

    @Autowired
    private Forstaff_chatListService fcls;

    /**
     * 获得设计师-用户的所有聊天信息
     * @param user_id 用户id
     * @param des_id 设计师id
     * @param numNotstatus 未读信息
     * @return map数据集合
     */
    @GetMapping("/getChatList")
    public List<Map<String,Object>> getChatList(Integer user_id,Integer des_id,Integer numNotstatus){
        //拿到usertitle
        String usertitle=fguds.getUsertitle();
        System.out.println("usertitle:"+usertitle);
        //拿到designertitle
        String designertitle=fguds.getDesignertitle();
        System.out.println("designertitle:"+designertitle);
        System.out.println("查询聊天的:"+usertitle+user_id+";"+designertitle+des_id);
        if (numNotstatus!=-1){
            //将所有未读消息改为已读
            Integer sNum=fcls.changeChatListStatus(usertitle+user_id,designertitle+des_id);
        }
        //得到用户-设计师所有的聊天信息
        List<Map<String,Object>> lis=fcls.getChatList(usertitle+user_id,designertitle+des_id);
        if(lis.size()!=0){
            for (Map<String,Object> m:lis
                 ) {
                Set<Map.Entry<String, Object>> set = m.entrySet();
                Iterator<Map.Entry<String, Object>> iterator = set.iterator();
                while(iterator.hasNext()){
                    Map.Entry<String, Object> next = iterator.next();
                    //时间转格式
                    if (next.getKey().equals("send_time")){
                        Date value = (Date) next.getValue();
                        String s = new SimpleDateFormat("MM-dd HH:mm").format(value);
                        m.put("send_time",s);
                    }
                }
            }
        }
        //拿到user_url
        String des_url=fcls.qureyUrl(des_id);
        HashMap<String, Object> map = new HashMap<>();
        map.put("des_url",des_url);
        //拿到designer_url
        String user_url=fcls.qureyDesUrl(user_id);
        map.put("user_url",user_url);
        map.put("usertitle",usertitle);
        map.put("designertitle",designertitle);
        lis.add(map);
        System.out.println(lis);
        return lis;
    }

    //发送的是文字消息
    /*@RequestMapping("/sendTextMessage")
    public String message(String message){
        new MQconfig().userQueue("userAndDes");

        return "success";
    }*/
}
