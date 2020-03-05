package com.peilw.child.mydesign.factory_method;
//抽象工厂类
public abstract  class Creator {
    public abstract <T extends Product> T creteProduct(Class<T> c);
}
