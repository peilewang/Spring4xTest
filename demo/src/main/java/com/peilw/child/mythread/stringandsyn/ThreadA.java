package com.peilw.child.mythread.stringandsyn;

public class ThreadA extends Thread{
    private Service service;
    public ThreadA(Service service){
        this.service=service;
    }
    @Override
    public void run(){
        service.print("AA");
    }
}
