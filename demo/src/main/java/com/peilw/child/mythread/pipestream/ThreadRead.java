package com.peilw.child.mythread.pipestream;

import java.io.PipedInputStream;

public class ThreadRead extends Thread{
    private ReadData readData;
    private PipedInputStream pipedInputStream;
    public ThreadRead(ReadData readData,PipedInputStream pipedInputStream){
        this.pipedInputStream=pipedInputStream;
        this.readData=readData;
    }
    @Override
    public void run(){
        readData.readMethod(pipedInputStream);
    }
}
