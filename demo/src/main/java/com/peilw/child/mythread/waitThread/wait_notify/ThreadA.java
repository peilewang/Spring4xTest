package com.peilw.child.mythread.waitThread.wait_notify;

public class ThreadA extends Thread{
    private Object lock;
    public ThreadA(Object lock){
       this.lock=lock;
    }
    @Override
    public void run(){
        synchronized (lock){
            if(MyList.size()!=5){
                System.out.println("wait begin "+System.currentTimeMillis());
                try {
                    lock.wait();
                    System.out.println("wait end "+System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
