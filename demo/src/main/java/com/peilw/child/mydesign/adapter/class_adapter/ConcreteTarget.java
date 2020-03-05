package com.peilw.child.mydesign.adapter.class_adapter;
//目标角色实现类
public class ConcreteTarget implements Targert{
    @Override
    public void request() {
        System.out.println("if you need any help,pls call me!");
    }
}
