package com.peilw.child.mythread.stringandsyn;

public class run {
    public static void main(String args[]){
        Service service=new Service();
        ThreadA threadA=new ThreadA(service);
        threadA.setName("A");
        threadA.start();
        ThreadB threadB=new ThreadB(service);
        threadB.setName("B");
        threadB.start();
    }
}
