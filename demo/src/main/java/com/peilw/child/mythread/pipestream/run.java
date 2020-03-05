package com.peilw.child.mythread.pipestream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class run {
    public static void main(String[] args){
        try {
            WriteData writeData=new WriteData();
            ReadData readData=new ReadData();
            PipedInputStream inputStream=new PipedInputStream();
            PipedOutputStream pipedOutputStream=new PipedOutputStream();
            pipedOutputStream.connect(inputStream);
            ThreadRead threadRead=new ThreadRead(readData,inputStream);
            threadRead.start();
            ThreadRead.sleep(2000);
            ThreadWrite threadWrite=new ThreadWrite(writeData,pipedOutputStream);
            threadWrite.start();
        }catch (IOException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
