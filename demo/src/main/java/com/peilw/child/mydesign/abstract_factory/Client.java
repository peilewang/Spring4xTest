package com.peilw.child.mydesign.abstract_factory;

public class Client {
    AbstractCreator creator1=new Creator1();
    AbstractCreator creator2=new Creator2();
    AbstractProductA a1=creator1.productA();
    AbstractProductA a2=creator2.productA();
    AbstractProductB b1=creator1.productB();
    AbstractProductB b2=creator2.productB();

}
