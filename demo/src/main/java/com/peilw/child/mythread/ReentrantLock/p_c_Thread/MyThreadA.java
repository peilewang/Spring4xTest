package com.peilw.child.mythread.ReentrantLock.p_c_Thread;


public class MyThreadA extends Thread{
    private MyService myService;
    public MyThreadA(MyService myService){
        this.myService=myService;
    }
    @Override
    public void run(){
        for(int i=0;i<Integer.MAX_VALUE;i++){
            myService.set();
        }
    }
}
