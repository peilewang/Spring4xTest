package com.peilw.child.mythread.ReentrantReadWriteLock;

public class ThreadB extends Thread{
    public Service service;
    public ThreadB(Service service){
        this.service=service;
    }
    @Override
    public void run(){
        service.write();
    }
}
