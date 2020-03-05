package com.peilw.child.mythread.ReentrantReadWriteLock;

public class ThreadA  extends Thread{
    public Service service;
    public ThreadA(Service service){
        this.service=service;
    }
    @Override
    public void run(){
        service.read();
    }
}
