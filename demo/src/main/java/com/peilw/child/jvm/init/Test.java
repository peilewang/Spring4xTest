package com.peilw.child.jvm.init;

public class Test {
    static {
        i=0;//给变量赋值可以正常编译通过
        //System.out.println(i); 非法向前引用   静态语句块中只能访问到定义在静态语句块之前的变量，定义在它之后的变量，在前面的语句块可以赋值，不能访问变量
    }
    static int i=0;
}
