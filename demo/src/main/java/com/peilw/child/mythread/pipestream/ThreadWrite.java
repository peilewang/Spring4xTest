package com.peilw.child.mythread.pipestream;

import java.io.PipedOutputStream;

public class ThreadWrite extends Thread{
    private WriteData writeData;
    private PipedOutputStream pipedOutputStream;
    public  ThreadWrite(WriteData writeData,PipedOutputStream pipedOutputStream){
        this.pipedOutputStream=pipedOutputStream;
        this.writeData=writeData;
    }
    @Override
    public void run(){
        writeData.writeMethod(pipedOutputStream);
    }
}
