package com.peilw.child.mythread.single.static_single;

import java.security.Signature;

public class Singleton {
    private Singleton(){

    }
    private static Singleton singleton=null;
    static {
        singleton=new Singleton();
    }
    public static Singleton getSingleton(){
       return
               singleton;
    }
}
