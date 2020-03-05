package com.peilw.child.executors.ThreadFactory;

public class ThreadTask implements Runnable {
    private String taskName;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public ThreadTask(String name) {
        this.setTaskName(name);
    }

    public void run() {
        //输出执行线程的名称
        System.out.println("TaskName" + this.getTaskName() + "---ThreadName:" + Thread.currentThread().getName());
    }
}