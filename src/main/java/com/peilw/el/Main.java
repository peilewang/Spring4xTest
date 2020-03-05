package com.peilw.el;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args){
        AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext(ElConfig.class);
        ElConfig elConfig=annotationConfigApplicationContext.getBean(ElConfig.class);
        elConfig.outputResource();
        annotationConfigApplicationContext.close();
    }
}
