package com.peilw.child.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalConfig {
    @ModelAttribute(value = "info")
    public Map<String,String> userInfo(){
        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("userName","罗贯中");
        hashMap.put("gender","男");
        return  hashMap;
    }
}
