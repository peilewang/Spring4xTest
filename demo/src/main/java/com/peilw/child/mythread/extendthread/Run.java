package com.peilw.child.mythread.extendthread;

public class Run {
    public  static void main(String[] args){
           MyThread myThread=new MyThread(1);
           MyThread myThread2=new MyThread(2);
           MyThread myThread3=new MyThread(3);
           MyThread myThread4=new MyThread(4);
           MyThread myThread5=new MyThread(5);
           MyThread myThread6=new MyThread(6);
           myThread.start();
           myThread2.start();
           myThread3.start();
           myThread4.start();
           myThread5.start();
           myThread6.start();
           System.out.println("运行结束");
    }
}
