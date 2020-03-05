package com.peilw.child.mydesign.factory_method;

public class Client {
    public static void main(String[] args){
        Creator creator=new ConcreteCreator();
        Product product=creator.creteProduct(ConcreteProduct1.class);
    }
}
