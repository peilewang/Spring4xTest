package com.peilw.child.mythread.threadpriority;

public class run {
    public static void main(String[] args){
        for(int i=0;i<5;i++) {
            MyThread myThread = new MyThread();
            myThread.setPriority(10);
            myThread.start();
            MyThread2 myThread2=new MyThread2();
            myThread2.setPriority(1);
            myThread2.start();
        }
    }
}
