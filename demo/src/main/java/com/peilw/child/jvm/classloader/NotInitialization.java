package com.peilw.child.jvm.classloader;

public class NotInitialization {
    public static void main(String[] args) {
        System.out.println(SubClass.value);
        //被动使用字段演示二：
        //通过数组定义来引用类，不会触发此类的初始化
        SuperClass[] sca = new SuperClass[10];
        //被动使用类字段演示三
        //常量在编译阶段会存入调用类的常量池中，本质上并没有直接引用到定义常量的类，因此不会触发定义常量的初始化
        System.out.println(ConstClass.helloWord);
    }
}
