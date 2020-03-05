package com.peilw.child.mydesign.single.static_single;

public class Singleton {
    private Singleton(){

    }
    private static Singleton singleton=null;
    static {
        singleton=new Singleton();
    }
    public static Singleton getSingleton(){
       return singleton;
    }
}
