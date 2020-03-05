package com.peilw.child.mythread.stopthread.improve;

public class MyThread  extends Thread{
    @Override
    public void run(){
        try {
            for (int i = 1; i < 500000; i++) {
                if (this.isInterrupted()) {
                    System.out.println("已经是停止状态了!我要退出了");
                    throw new InterruptedException();
                }
                System.out.println("i=" + i);
            }
            System.out.println("我被输出了，线程并未停止");
        }catch (InterruptedException e){
            System.out.println("进入catch方法");
            e.printStackTrace();
        }
    }
}
