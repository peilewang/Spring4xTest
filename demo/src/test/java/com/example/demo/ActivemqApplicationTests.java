/*
package com.example.demo;

import com.peilw.child.components.JmsComponent;
import com.peilw.child.entity.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivemqApplicationTests {
    @Autowired
    JmsComponent jmsComponent;
    @Test
    public void contextLoads(){
        Message message=new Message();
        message.setContent("hello jms");
        message.setName("xiaoli");
        jmsComponent.send(message);
    }
}
*/
