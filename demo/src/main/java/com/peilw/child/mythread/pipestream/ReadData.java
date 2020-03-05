package com.peilw.child.mythread.pipestream;

import java.io.IOException;
import java.io.PipedInputStream;

public class ReadData {
    public void readMethod(PipedInputStream pipedInputStream){
        try {
            System.out.println("read");
            byte[] bytes=new byte[20];
            int readLength=pipedInputStream.read(bytes);
            while (readLength!=-1){
                String newData=new String(bytes,0,readLength);
                System.out.println("读取 "+newData);
                readLength=pipedInputStream.read(bytes);
            }
            System.out.println();
            pipedInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
