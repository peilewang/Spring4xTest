package com.peilw.child.mydesign.abstract_factory;
//产品等级1的实现类
public class Creator1 extends AbstractCreator{
    @Override
    public AbstractProductA productA() {
        return new productA1();
    }
     //只生产产品等级为1的产品
    @Override
    public AbstractProductB productB() {
        return new productB1();
    }
}
