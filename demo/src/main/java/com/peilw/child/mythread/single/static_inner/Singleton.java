package com.peilw.child.mythread.single.static_inner;

public class Singleton {
    private Singleton(){

    }
    private static class MyObjectHandler{
        private static Singleton singleton=new Singleton();
    }
    public  static Singleton getInstance(){
        return MyObjectHandler.singleton;
    }
}
