package com.peilw.child.mythread.DeathThread;

public class Run {
    public static void main(String[] args){
        try {
            DealThread dealThread=new DealThread();
            dealThread.setFlag("a");
            Thread thread=new Thread(dealThread);
            thread.start();
            Thread.sleep(100);
            dealThread.setFlag("b");
            Thread thread1=new Thread(dealThread);
            thread1.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
