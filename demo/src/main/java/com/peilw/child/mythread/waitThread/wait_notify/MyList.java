package com.peilw.child.mythread.waitThread.wait_notify;

import java.util.ArrayList;
import java.util.List;

public class MyList {
    private static List list=new ArrayList();
    public static void add(){
        list.add("1111");
    }
    public static int size(){
        return list.size();
    }
}
