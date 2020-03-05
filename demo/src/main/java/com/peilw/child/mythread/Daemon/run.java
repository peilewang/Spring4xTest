package com.peilw.child.mythread.Daemon;

public class run {
    public static void main(String[] args){
        try {
            MyThread myThread=new MyThread();
            myThread.setDaemon(true);
            myThread.start();
            Thread.sleep(5000);
            System.out.println("我离开tread对象也不再打印了，也就是停止了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
