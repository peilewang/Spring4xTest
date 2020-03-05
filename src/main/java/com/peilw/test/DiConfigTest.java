package com.peilw.test;

import com.peilw.config.DiConfig;
import com.peilw.service.impl.UserFunctionService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DiConfigTest {
    public static void main(String args[]){
        AnnotationConfigApplicationContext configApplicationContext=new AnnotationConfigApplicationContext(DiConfig.class);
        UserFunctionService userFunctionService=configApplicationContext.getBean(UserFunctionService.class);
        System.out.println(userFunctionService.SayHello("di"));
        configApplicationContext.close();
    }
}
