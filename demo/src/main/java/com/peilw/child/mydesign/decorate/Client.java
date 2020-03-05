package com.peilw.child.mydesign.decorate;

public class Client {
    public static void main(String[] args){
        Component component=new ConcreteComponent();
        component=new ConcreteDecorator1(component);//第一次修饰
        component=new ConcreteDecorator2(component);//第二次修饰
        component.operate();
    }
}
