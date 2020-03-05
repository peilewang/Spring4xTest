package com.peilw.CustomAnnotation.aop;

import org.springframework.stereotype.Service;

@Service
public class DemoAnnotionService {
    @Action(name="注解式的add操作")
    public  void add(){}
}
