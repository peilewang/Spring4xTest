package com.peilw.CustomAnnotation.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class aopTest {
    public static void main(String[] args){
        AnnotationConfigApplicationContext configApplicationContext=new AnnotationConfigApplicationContext(AopConfig.class);
        DemoAnnotionService userFunctionService=configApplicationContext.getBean(DemoAnnotionService.class);
        DemoMethodService demoMethodService=configApplicationContext.getBean(DemoMethodService.class);
        userFunctionService.add();
        demoMethodService.add();
        configApplicationContext.close();
    }
}
