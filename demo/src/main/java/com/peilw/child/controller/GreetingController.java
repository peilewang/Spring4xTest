package com.peilw.child.controller;

import com.sun.xml.internal.ws.api.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Message greeting(Message message) {
        return message;
    }
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;
    @MessageMapping("/hello1")
    public void greeting1(Message message){
        simpMessagingTemplate.convertAndSend("/topic/greetings",message);
    }
}
