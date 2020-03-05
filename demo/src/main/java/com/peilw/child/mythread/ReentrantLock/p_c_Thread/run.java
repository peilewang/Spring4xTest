package com.peilw.child.mythread.ReentrantLock.p_c_Thread;


public class run {
    public static void main(String[] args){
        MyService myService=new MyService();
        MyThreadA myThreadA=new MyThreadA(myService);
        myThreadA.start();
        MyThreadB myThreadB=new MyThreadB(myService);
        myThreadB.start();
    }
}
