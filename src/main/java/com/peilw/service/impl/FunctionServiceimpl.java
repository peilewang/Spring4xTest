package com.peilw.service.impl;

import com.peilw.service.FunctionService;
import org.springframework.stereotype.Service;

@Service
public class FunctionServiceimpl implements FunctionService {
   @Override
    public String SayHello(String world){
        return  "hello"+world+"!";
    }
}
