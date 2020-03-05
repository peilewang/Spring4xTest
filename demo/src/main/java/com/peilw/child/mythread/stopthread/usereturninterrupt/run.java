package com.peilw.child.mythread.stopthread.usereturninterrupt;

public class run {
    public static void main(String[] args){
        try {
            MyThread myThread=new MyThread();
            myThread.start();
            Thread.sleep(2000);
            myThread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
