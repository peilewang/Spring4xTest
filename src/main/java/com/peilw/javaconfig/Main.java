package com.peilw.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args){
        AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext(JavaConfig.class);
        UserFunctionService userFunctionService=annotationConfigApplicationContext.getBean(UserFunctionService.class);
        System.out.println(userFunctionService.sayHello("java config"));
        annotationConfigApplicationContext.close();
    }
}
