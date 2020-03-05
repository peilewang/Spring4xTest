package com.peilw.child.mydesign.decorate;
//具体装饰者
public class ConcreteDecorator1 extends Decorator{
    public ConcreteDecorator1(Component component) {
        super(component);
    }
    private void method1(){
        System.out.println("method1 装饰");
    }
    public void operate(){
        this.method1();
        super.operate();
    }
}
