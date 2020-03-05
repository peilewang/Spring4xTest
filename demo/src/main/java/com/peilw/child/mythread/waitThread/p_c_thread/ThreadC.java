package com.peilw.child.mythread.waitThread.p_c_thread;

public class ThreadC extends Thread{
    private C c;
    public ThreadC(C c){
        this.c=c;
    }
    @Override
    public void run(){
        while (true){
            c.getValue();
        }
    }
}
