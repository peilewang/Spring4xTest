package com.peilw.child.mythread.ReentrantLock;

public class ThreadAA extends Thread{
    private MyService myService;
    public ThreadAA(MyService myService){
        this.myService=myService;
    }
    @Override
    public void run(){
        myService.methodA();
    }
}
