package com.peilw.child.mydesign.abstract_factory;

public class Creator2 extends  AbstractCreator{
    @Override
    //只生产产品等级为2的A产品
    public AbstractProductA productA() {
        return new productA2() ;
    }

    @Override
    public AbstractProductB productB() {
        return null;
    }
}
