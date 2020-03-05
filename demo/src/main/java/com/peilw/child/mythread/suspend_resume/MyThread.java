package com.peilw.child.mythread.suspend_resume;

public class MyThread extends Thread{
    public long getI() {
        return i;
    }

    public void setI(long i) {
        this.i = i;
    }

    private long i=0;
    @Override
    public void run(){
        while (true){
            i++;
            //System.out.println("i="+i);
        }
    }
}
