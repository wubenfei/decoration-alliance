package com.ours.userapp.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.ours.entity.ChatRecord;
import com.ours.userapp.service.forstaffService.ChatService;
import com.ours.userapp.utils.WebSocketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: WebSocket
 * @Description: WebSocket的处理类
 * @author: WLJ
 * @date ：Created in 2019/12/30 13:06
 */
@Component
@ServerEndpoint("/websocket/{username}")
public class WebSocket {
    private final static  Logger logger = LoggerFactory.getLogger(WebSocket.class);
    /**
     * 在线人数
     */
    public static int onlineNumber = 0;
    /**
     * 以用户的姓名为key，WebSocket为对象保存起来
     * 每一个连接客户端的都是websocket对象
     * 保存所有的客户端
     */
    private static Map<String, WebSocket> clients = new ConcurrentHashMap<String, WebSocket>();
    /**
     * 会话
     */
    private Session session;
    /**
     * 用户名称
     */
    private String username;

    /**
     * 建立连接
     * 连接的时候的方法
     * @param session
     */
    @OnOpen
    public void onOpen(@PathParam("username")String username,
                       Session session) {
        Map<String, String> map = session.getPathParameters();
        System.out.println("session.getPathParameters()"+map.toString());
        String str = session.getQueryString();
        System.out.println("session.getQueryString()"+str);
        String uri = session.getRequestURI().toString();
        System.out.println("session.getRequestURI().toString()"+uri);
        logger.info("websocket连接.......");
        onlineNumber++;
        //logger.info("现在来连接的客户id：" + session.getId() + "用户名：" + username);
        logger.info("现在来连接的客户用户名：" + username);
        this.username = username;
        this.session = session;
        logger.info("......有新连接加入！ 当前在线人数:" + onlineNumber);
        //去查询历史信息
        try {
            //messageType 1代表上线 2代表下线 3代表在线名单 4代表普通消息
            //先给所有人发送通知，说我上线了
            //单发,没必要
            /*Map<String, Object> map1 = Maps.newHashMap();
            map1.put("messageType", 1);
            map1.put("username", username);
            sendMessageAll(JSON.toJSONString(map1), username);*/
            //把自己的信息加入到map当中去,即添加客户端
            clients.put(username, this);
            //提示发送成功
            Map<String, Object> map2 = Maps.newHashMap();
            map2.put("success", username+"上线发送成功");
            sendMessageTo(JSON.toJSONString(map2), username);

            //给自己发一条消息：告诉自己现在都有谁在线(不是群发,没必要了)
            //Map<String, Object> map2 = Maps.newHashMap();
            //map2.put("messageType", 3);
            //移除掉自己
            //Set<String> set = clients.keySet();
            //map2.put("onlineUsers", set);
            //sendMessageTo(JSON.toJSONString(map2), username);
        } catch (Exception e) {
            logger.error(username + "上线的时候通知所有人发生了错误");
        }


    }

    @OnError
    public void onError(Session session, Throwable error) {
        logger.info("服务端发生了错误" + error.getMessage());
        //error.printStackTrace();
    }

    /**
     * 连接关闭
     */
    @OnClose
    public void onClose() {
        onlineNumber--;
        //webSockets.remove(this);
        clients.remove(username);
        System.out.println("关闭连接:"+username);
        try {
            //messageType 1代表上线 2代表下线 3代表在线名单  4代表普通消息
            Map<String, Object> map1 = Maps.newHashMap();
            map1.put("messageType", 2);
            map1.put("onlineUsers", clients.keySet());
            map1.put("username", username);
            sendMessageAll(JSON.toJSONString(map1), username);
        } catch (IOException e) {
            logger.info(username + "下线的时候通知所有人发生了错误");
        }
        logger.info("有连接关闭！ 当前在线人数" + onlineNumber);
    }

    /**
     * 收到客户端的消息
     * @param message 消息
     * @param session 会话
     */
    @OnMessage
    public void onMessage(String message, Session session) {

        try {
            if(message!=null){
                //设置全局变量
                ApplicationContext act = WebSocketService.getApplicationContext();
                //获得service的实例
                ChatService chatService = act.getBean(ChatService.class);
                //添加消息到数据库的方法
                //bean.addmessage(message);

            //logger.info("来自客户端消息：" + message + "客户端的id是：" + session.getId());
            logger.info("来自客户端消息：" + message);
            JSONObject jsonObject = JSON.parseObject(message);
            /*String type = jsonObject.getString("type");
            String msg = jsonObject.getString("msg");
            String fromusername = jsonObject.getString("username");
            String tousername = jsonObject.getString("to");*/
            if (jsonObject.getString("event")!=null){
                //发送个人信息事件
                if (jsonObject.getString("event").equals("sendMess")){
                    String data=jsonObject.getString("data");
                    JSONObject jsonObjectdata = JSON.parseObject(data);
                    String mess=jsonObjectdata.getString("message");
                    String clientname=jsonObjectdata.getString("clientname");
                    System.out.println("信息:"+mess);
                    System.out.println("发送给:"+clientname);
                    String send_name=jsonObjectdata.getString("send_name");
                    String receiver_name=jsonObjectdata.getString("receiver_name");
                    //获得send_id和receiver_id
                    String[] tos = username.split("to");
                    //send_id
                    String send_id = tos[0];
                    String receiver_id = tos[1];
                    //获得时间
                    //String time=jsonObjectdata.getString("time");
                    //时间以后端为准
                    Date date = new Date();
                    //String s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
                    //信息类型
                    String type=jsonObjectdata.getString("type");
                    //插入信息
                    ChatRecord chatRecord = new ChatRecord();
                    chatRecord.setContent(mess);
                    chatRecord.setSendName(send_name);
                    chatRecord.setReceiverName(receiver_name);
                    chatRecord.setReceiverId(receiver_id);
                    chatRecord.setSendId(send_id);
                    chatRecord.setSendTime(date);
                    chatRecord.setType(type);
                    if (type.equals("img")){
                        Integer h=Integer.valueOf(jsonObjectdata.getString("h"));
                        Integer w=Integer.valueOf(jsonObjectdata.getString("w"));
                        chatRecord.setH(h);
                        chatRecord.setW(w);
                    }
                    //接收者
                    String other=receiver_id+"to"+send_id;
                    //看那个人在不在线
                    if (!clients.isEmpty()){
                        if (clients.get(other)!=null){
                            //存入数据库,默认已读
                            Integer i=chatService.insertChatRecord(chatRecord);
                            //在线发送给个人
                            System.out.println(other+"在线");
                            //发送给
                            HashMap<String, Object> map = new HashMap<String, Object>();
                            map.put("type",type);
                            HashMap<String, Object> messs1 = new HashMap<String, Object>();
                            messs1.put("content",mess);
                            map.put("msg",messs1);
                            sendMessageTo(JSON.toJSONString(map), other);
                        }else {
                            System.out.println("warning:"+other+"不在线!!!");
                            //接收者不在线的处理,存入数据库,为未读
                            chatRecord.setStatus(0);
                            //存入数据库,0未读
                            Integer i=chatService.insertChatRecord(chatRecord);
                        }
                    }else {
                        //接收者不在线的处理,存入数据库,为未读
                        chatRecord.setStatus(0);
                        //存入数据库,0未读
                        Integer i=chatService.insertChatRecord(chatRecord);
                    }
                }

                //关闭连接事件
                if (jsonObject.getString("event").equals("onClose")){
                    //关闭自己,断开会自己关闭不需要再手动关闭
                    //onClose();
                }

            }



            //如果不是发给所有，那么就发给某一个人
            //messageType 1代表上线 2代表下线 3代表在线名单  4代表普通消息
            /*Map<String, Object> map1 = Maps.newHashMap();
            map1.put("messageType", 4);
            map1.put("type", type);
            map1.put("msg", msg);*/
            /*if (tousername.equals("All")) {
                map1.put("tousername", "所有人");
                sendMessageAll(JSON.toJSONString(map1), fromusername);
            } else {
                map1.put("tousername", tousername);
                sendMessageTo(JSON.toJSONString(map1), tousername);
            }*/
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("发生了错误了");
        }

    }

    //转发到单个客户端
    public void sendMessageTo(String message, String ToUserName) throws IOException {
        for (WebSocket item : clients.values()) {
            if (item.username.equals(ToUserName)) {
                item.session.getAsyncRemote().sendText(message);
                break;
            }
        }
    }
    //转发到所有群发
    public void sendMessageAll(String message, String FromUserName) throws IOException {
        for (WebSocket item : clients.values()) {
            if (!item.username.equals(FromUserName)) {
                item.session.getAsyncRemote().sendText(message);
            }
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineNumber;
    }
}
