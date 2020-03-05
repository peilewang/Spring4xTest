package com.peilw.child.mydesign.strategy.enum_strategy;

import java.util.Arrays;

public class Client {
    public static void main(String[] args){
        int a=Integer.parseInt(args[0]);
        String symbo=args[1];
        int b=Integer.parseInt(args[1]);
        System.out.println("输入参数为："+Arrays.toString(args));
        System.out.println("运行结果为："+a+symbo+b+"="+CalCulator.Add.exec(a,b));
    }
}
