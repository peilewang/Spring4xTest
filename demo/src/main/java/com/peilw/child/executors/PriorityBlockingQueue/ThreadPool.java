package com.peilw.child.executors.PriorityBlockingQueue;

import java.util.concurrent.*;

public class ThreadPool {
    private static ExecutorService pool;
    public static void main( String[] args )
    {
        //优先任务队列
        pool = new ThreadPoolExecutor(1, 2, 1000, TimeUnit.MILLISECONDS, new PriorityBlockingQueue<Runnable>(),Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        for(int i=0;i<20;i++) {
            pool.execute(new ThreadTask(i));
        }
    }
}
