package com.peilw.child.mythread.ReentrantLock.p_c_Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private Lock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();
    private boolean hasValue=false;
    public void set(){
        try{
            lock.lock();
            while (hasValue==true){
                condition.await();
            }
            System.out.println("打印111");
            hasValue=true;
            condition.signal();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void get(){
        try{
            lock.lock();
            while (hasValue==false){
                condition.await();
            }
          System.out.println("打印222");
          hasValue=false;
          condition.signal();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

