package com.peilw.child.mythread.ReentrantLock;

public class run {
    public static void main(String[] args){
        MyService myService=new MyService();
        ThreadA threadA=new ThreadA(myService);
        threadA.setName("A");
        ThreadAA threadAA=new ThreadAA(myService);
        threadAA.setName("AA");
        ThreadB threadB=new ThreadB(myService);
        threadB.setName("B");
        ThreadBB threadBB=new ThreadBB(myService);

        threadBB.setName("BB");
        threadA.start();
        threadAA.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadB.start();
        threadBB.start();
    }
}
