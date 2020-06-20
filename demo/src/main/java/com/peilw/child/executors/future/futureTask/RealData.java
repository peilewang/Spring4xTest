package com.peilw.child.executors.future.futureTask;

public class RealData {
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
}
