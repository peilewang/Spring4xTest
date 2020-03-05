package com.peilw.child.mythread.threadlocal;

public class run {
    public static void main(String[] args){
        try {
            ThreadA threadA=new ThreadA();
            ThreadB threadB=new ThreadB();
            threadA.start();
            threadB.start();
            for(int i=0;i<100;i++) {
                Tools.t1.set("main"+(i+1));
                System.out.println("Main get Value="+Tools.t1.get());
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
