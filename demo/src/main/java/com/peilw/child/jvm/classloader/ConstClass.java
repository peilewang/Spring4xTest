package com.peilw.child.jvm.classloader;

public class ConstClass {
    static {
        System.out.println("ConstClass init");
    }

    public static final String helloWord = "helloWord";
}
