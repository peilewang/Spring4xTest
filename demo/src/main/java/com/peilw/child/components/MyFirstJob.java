package com.peilw.child.components;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyFirstJob {
    public void sayHello() {
        System.out.println("MyFirstJob:hello:" + new Date());
    }
}
