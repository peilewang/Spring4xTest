package com.peilw.child.controller;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class MyErrorViewResolver implements ErrorViewResolver {
    @Override
   public ModelAndView resolveErrorView(HttpServletRequest request , HttpStatus
    status , Map<String, Object> model ) {
         ModelAndView mv = new ModelAndView("error Page");
         mv.addObject("custommsg ","咄错啦！！");
         mv.addAllObjects(model);
         return mv;
    }
}
