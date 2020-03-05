package com.peilw.child.mythread.groupAddThread;

public class run {
    public static void main(String[] args){
        ThreadA threadA=new ThreadA();
        ThreadB threadB=new ThreadB();
        ThreadGroup threadGroup=new ThreadGroup("线程组");
        Thread athread=new Thread(threadGroup,threadA);
        Thread bthread=new Thread(threadGroup,threadB);
        athread.start();
        bthread.start();
        System.out.println("活动的线程数为: "+threadGroup.activeCount());
        System.out.println("线程组的名称为: "+threadGroup.getName());
    }
}
