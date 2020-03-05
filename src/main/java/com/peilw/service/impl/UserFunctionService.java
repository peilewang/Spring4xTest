package com.peilw.service.impl;

import com.peilw.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserFunctionService {
    @Autowired
    FunctionService functionService;
    public String SayHello(String world){
        return functionService.SayHello(world);
    }
}
