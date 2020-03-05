package com.peilw.child.mydesign.decorate;
//抽象装饰者
public abstract class Decorator extends Component{
     private Component component;
     public Decorator(Component component){
         this.component=component;
     }
     @Override
    public void operate(){
         this.component.operate();
     }
}
