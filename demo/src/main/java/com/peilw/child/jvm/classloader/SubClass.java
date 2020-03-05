package com.peilw.child.jvm.classloader;

public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init");
    }

}
