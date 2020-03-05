package com.peilw.child.mydesign.single.hungry;

public class MyObject {
    private  static MyObject myObject=new MyObject();
    private MyObject(){

    }
    public static MyObject getInstance(){
        return  myObject;
    }

}
