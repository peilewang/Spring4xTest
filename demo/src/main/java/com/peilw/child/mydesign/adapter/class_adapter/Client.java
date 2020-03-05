package com.peilw.child.mydesign.adapter.class_adapter;

public class Client {
    public static void main(String[] args){
        Targert targert=new ConcreteTarget();
        targert.request();
        Targert targert1=new Adapter();
        targert1.request();
    }
}
