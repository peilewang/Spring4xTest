package com.peilw.child.mythread.single.lazy;

public class Singleton {
  volatile   private static Singleton singleton;
    private Singleton(){

    }
    public static Singleton getSingleton(){
        if(singleton==null){
           synchronized (Singleton.class){
                if(singleton==null){
                      singleton=new Singleton();
                }
           }
        }
        return  singleton;
    }
}
