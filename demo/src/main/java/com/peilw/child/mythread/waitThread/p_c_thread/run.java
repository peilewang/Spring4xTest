package com.peilw.child.mythread.waitThread.p_c_thread;

public class run {
    public static void main(String[] args){
        String lock=new String("");
        p p=new p(lock);
        C c=new C(lock);
        ThreadP threadP=new ThreadP(p);
        ThreadC threadC=new ThreadC(c);
        threadP.start();
        threadC.start();
    }
}
