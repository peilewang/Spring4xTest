package com.peilw.child.mythread.waitThread.p_c_thread;

public class ThreadP extends Thread{
    private p p;
    public ThreadP(p p){
        this.p=p;
    }
    @Override
    public void run(){
        while (true){
            p.setValue();
        }
    }
}
