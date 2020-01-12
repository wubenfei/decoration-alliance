package com.ours.userapp.controller;

import com.ours.userapp.service.forstaffService.ChatService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: ChatController
 * @Description:
 * @author: WLJ
 * @date ：Created in 2020/1/2 10:33
 */
@RestController
@CrossOrigin
public class Forstaff_chatController {
    @Resource
    private ChatService chatService ;
    public void addmessage(String message){
        chatService.addmessage(message);
    }
}
