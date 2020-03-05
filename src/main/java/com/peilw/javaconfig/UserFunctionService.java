package com.peilw.javaconfig;

public class UserFunctionService {
    FunctionService functionService;
    public void setFunctionService(FunctionService functionService){
          this.functionService=functionService;
    }
    public String sayHello(String world){
        return  functionService.sayHello(world);
    }
}
