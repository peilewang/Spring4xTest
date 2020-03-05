package com.peilw.child.components;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class FanoutReceiver {
    @RabbitListener(queues ="queue-one")
    public void handler1(String message){
        System.out.println("FanoutReceiver:handler1:"+message);
    }
    @RabbitListener(queues ="queue-two")
    public void handler2(String message){
        System.out.println("FanoutReceiver:handler2:"+message);
    }
}
