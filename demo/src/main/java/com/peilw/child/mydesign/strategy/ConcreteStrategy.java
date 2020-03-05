package com.peilw.child.mydesign.strategy;
//具体策略角色
public class ConcreteStrategy implements Strategy{
    @Override
    public void doSomething() {
        System.out.println("具体策略算法1");
    }
}
