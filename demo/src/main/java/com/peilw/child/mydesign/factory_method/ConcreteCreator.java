package com.peilw.child.mydesign.factory_method;
//具体工厂类
public class ConcreteCreator extends Creator{
    @Override
    public <T extends Product> T creteProduct(Class<T> c) {
        Product product=null;
        try {
            product=(Product) Class.forName(c.getName()).newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return (T) product;
    }
}
