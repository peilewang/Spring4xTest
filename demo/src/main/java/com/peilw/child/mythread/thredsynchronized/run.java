package com.peilw.child.mythread.thredsynchronized;

public class run {
    public static void main(String[] args){
        try {
            PublicVar publicVar=new PublicVar();
            ThreadA threadA=new ThreadA(publicVar);
            threadA.start();
            Thread.sleep(200);
            publicVar.getValue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
