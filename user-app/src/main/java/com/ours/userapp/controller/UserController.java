package com.ours.userapp.controller;

import com.netflix.client.ClientException;
import com.ours.entity.User;
import com.ours.entity.UserDec;
import com.ours.userapp.conmon.SmsUtil;
import com.ours.userapp.service.UserAppService;
import com.ours.userapp.utils.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;


@CrossOrigin
@Controller
public class UserController {

    @Autowired
    UserAppService userAppService;

    public static String message = null;

    //注册请求
    @RequestMapping("register")
    @ResponseBody
    public int register(String phone,String password,String code,String username){
        System.out.println("查询到的消息为"+message);
        String encrypt = EncryptUtil.encrypt(password);
        if(message.equals(code)){
            int i = userAppService.insert(new User(username, phone, encrypt, "正常", "yonghu"));
            if (i != 0) {
                message = null;
                return 1;
            }
        }
        return 0;
    }

    //发送验证码请求
    @ResponseBody
    @RequestMapping("getCodeforReg")
    public String getCodeforReg(String phone) throws ClientException, com.aliyuncs.exceptions.ClientException {
        System.out.println("进入获取验证码请求"+phone);
        User user = userAppService.query(phone);
        if(user!=null){
            return null;
        }
        message = SmsUtil.sendSms(phone);
        return message;
    }

    //发送验证码请求
    @ResponseBody
    @RequestMapping("getCodeforRes")
    public String getCodeforRes(String phone) throws ClientException, com.aliyuncs.exceptions.ClientException {
        System.out.println("进入获取验证码请求"+phone);
        message = SmsUtil.sendSms(phone);
        return message;
    }

    //重设密码请求
    @ResponseBody
    @RequestMapping("resetPwd")
    public int resetPwd(String phone,String code,String password){
        if(!code.equals(message)){
            return 2;
        }
        User user = userAppService.query(phone);
        if(user==null){
            return 3;
        }
        String encrypt = EncryptUtil.encrypt(password);
        int i = userAppService.updataPwd(phone, encrypt);
        return i;
    }
}
