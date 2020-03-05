package com.peilw.child.mythread.single.hungry;

public class MyObject {
    private  static MyObject myObject=new MyObject();
    private MyObject(){

    }
    public static MyObject getInstance(){
        return  myObject;
    }

}
