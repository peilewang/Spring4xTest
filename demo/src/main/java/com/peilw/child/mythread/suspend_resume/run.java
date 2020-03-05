package com.peilw.child.mythread.suspend_resume;

public class run {
    public static void main(String[] args){
        try {
            MyThread myThread=new MyThread();
            myThread.start();
            Thread.sleep(5000);
            myThread.suspend();
            System.out.println("A="+System.currentTimeMillis()+" i="+myThread.getId());
            Thread.sleep(5000);
            System.out.println("A="+System.currentTimeMillis()+" i="+myThread.getId());
            myThread.resume();
            Thread.sleep(5000);
            myThread.suspend();
            System.out.println("B="+System.currentTimeMillis()+" i="+myThread.getId());
            Thread.sleep(5000);
            System.out.println("B="+System.currentTimeMillis()+" i="+myThread.getId());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
