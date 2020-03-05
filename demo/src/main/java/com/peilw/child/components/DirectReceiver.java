package com.peilw.child.components;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DirectReceiver {
    @RabbitListener(queues = "hello-queue")
    public void handler(String msg) {
        System.out.println("DirectReceiver:" + msg);
    }
}
