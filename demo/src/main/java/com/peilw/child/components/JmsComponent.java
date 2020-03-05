/*
package com.peilw.child.components;

import com.peilw.child.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

@Component
public class JmsComponent {
    @Autowired
    JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    Queue queue;
    public void send(Message message){
        jmsMessagingTemplate.convertAndSend(this.queue,message);
    }
    @JmsListener(destination = "amq")
    public void receive(Message message){
        System.out.println("receive:"+message);
    }
}
*/
