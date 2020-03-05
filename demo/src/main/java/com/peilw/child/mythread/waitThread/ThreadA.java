package com.peilw.child.mythread.waitThread;

public class ThreadA {
    public static void main(String[] args)
    {
        ThreadB b=new ThreadB();
        b.start();
        System.out.println("b is start....");
        synchronized(b)//括号里的b是什么意思,起什么作用?
        {
           try
           {
                System.out.println("Waiting for b to complete...");
                b.wait();//这一句是什么意思，究竟让谁wait?
                System.out.println("Completed.Now back to main thread");
           }catch (InterruptedException e){}
        }
        System.out.println("Total is :"+b.total);
        //synchronized(b){...}；的意思是定义一个同步块,使用b作为资源锁。b.wait();的意思是临时释放锁，并阻塞当前线程,好让其他使用同一把锁的线程有机会执行,在这里要用同一把锁的就是b线程本身.这个线程在执行到一定地方后用notify()通知wait的线程,锁已经用完,待notify()所在的同步块运行完之后,wait所在的线程就可以继续执行.
    }
}
