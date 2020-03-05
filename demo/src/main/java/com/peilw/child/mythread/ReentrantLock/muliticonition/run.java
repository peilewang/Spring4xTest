package com.peilw.child.mythread.ReentrantLock.muliticonition;

public class run {
    public static void main(String[] args){
        MyService myService=new MyService();
        ThreadA threadA=new ThreadA(myService);
        threadA.setName("A");
        threadA.start();
        ThreadB threadB=new ThreadB(myService);
        threadB.setName("B");
        threadB.start();
        try {
            Thread.sleep(3000);
            myService.signalAll_A();
            myService.signalAll_B();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
