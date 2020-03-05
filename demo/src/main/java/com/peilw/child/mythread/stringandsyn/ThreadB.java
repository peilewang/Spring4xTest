package com.peilw.child.mythread.stringandsyn;

public class ThreadB extends Thread{
    private Service service;
    public ThreadB(Service service){
        this.service=service;
    }
    @Override
    public void run(){
        service.print("AA");
    }
}
