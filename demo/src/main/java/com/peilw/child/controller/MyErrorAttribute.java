/*
package com.peilw.child.controller;

import org.omg.CORBA.ServerRequest;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;;
import java.util.HashMap;
import java.util.Map;


@Component
public class MyErrorAttribute extends DefaultErrorAttributes {
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean
            includeStackTrace) {
        Map<String, Object> errorAttributes =new HashMap<>();
                //super.getErrorAttributes(webRequest, includeStackTrace);
        errorAttributes.put("ustommsg ", "出错啦！");
        errorAttributes.remove("error");
        return errorAttributes;
    }
}*/
