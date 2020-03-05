package com.peilw.child.mythread.ReentrantLock.muliticonition;

public class ThreadA extends Thread{
    private MyService myService;
    public ThreadA(MyService myService){
        this.myService=myService;
    }
    public void run(){
        myService.waitA();
    }
}
