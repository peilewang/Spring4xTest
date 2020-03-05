package com.peilw.child.mythread.waitThread.p_c_thread;

public class p {
    private String lock;
    public p(String lock){
      this.lock=lock;
    }
    public void setValue(){
        try {
            synchronized (lock) {
                if(!ValueObject.value.equals("")){
                    lock.wait();
                }
                String value=System.currentTimeMillis()+"_"+System.nanoTime();
                System.out.println("set的值是"+value);
                ValueObject.value=value;
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
