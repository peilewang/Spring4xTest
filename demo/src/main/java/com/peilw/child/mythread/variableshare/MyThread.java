package com.peilw.child.mythread.variableshare;

public class MyThread extends Thread{
    private int count=5;
    @Override
    public  void run(){
            //super.run();
        try {
            Thread.sleep(1000);
            count--;
            System.out.println("由"+this.currentThread().getName()+"计算，count="+count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
