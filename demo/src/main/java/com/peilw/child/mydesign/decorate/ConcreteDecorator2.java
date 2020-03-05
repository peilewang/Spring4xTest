package com.peilw.child.mydesign.decorate;

public class ConcreteDecorator2 extends Decorator{
    public ConcreteDecorator2(Component component) {
        super(component);
    }
    public void method2(){
        System.out.println("method2修饰");
    }
    public void operate(){
        super.operate();
        this.method2();
    }
}
