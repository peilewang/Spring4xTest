package com.peilw.child.mydesign.strategy;
//封装角色
public class Context {
    private Strategy strategy;
    public Context(Strategy strategy){
        this.strategy=strategy;
    }
    public void doAnyThing(){
        this.strategy.doSomething();
    }
}
