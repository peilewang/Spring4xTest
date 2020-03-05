package com.peilw.child.mydesign.adapter.class_adapter;
//适配器角色
public class Adapter extends Adatee implements Targert{
    @Override
    public void request() {
        super.doSomething();
    }
}
