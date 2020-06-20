package com.peilw.child.executors.future.futureTask;

import java.util.concurrent.*;

public class FutureDemo1 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<String> future = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return new RealData().costTime();
            }
        });
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(future);

        System.out.println("RealData方法调用完毕");
        // 模拟主函数中其他耗时操作
        doOtherThing();
        // 获取RealData方法的结果
        System.out.println(future.get());
    }

    private static void doOtherThing() throws InterruptedException {
        Thread.sleep(2000L);
    }
}
