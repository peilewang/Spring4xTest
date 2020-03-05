package com.peilw.child.mythread.groupAddThread.groupInnerStop;


public class run {
    public static void main(String[] args){
        try {
            ThreadGroup threadGroup=new ThreadGroup("我的线程组");
            for(int i=0;i<5;i++){
               MyThread myThread=new MyThread(threadGroup,"线程"+(i+1));
               myThread.start();

            }
            Thread.sleep(5000);
            threadGroup.interrupt();
            System.out.println("调用了interrupt()方法");
        } catch (InterruptedException e) {
            System.out.println("停止了");
            e.printStackTrace();
        }
    }
}
