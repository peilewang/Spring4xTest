package com.peilw.child.executors.future;

import java.util.concurrent.Callable;

public class RealData2 implements Callable<String> {
    public String costTime() {
        try {
            // 模拟RealData耗时操作
            Thread.sleep(1000L);
            return "result";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "exception";
    }

    @Override
    public String call() throws Exception {
        return costTime();
    }
}
