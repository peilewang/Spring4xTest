package com.peilw.child.mythread.pipestream;

import java.io.IOException;
import java.io.PipedOutputStream;

public class WriteData {
    public void writeMethod(PipedOutputStream pipedOutputStream){
        try {
            System.out.println("write:");
            for(int i=0;i<300;i++){
                String outData=""+(i+1);
                pipedOutputStream.write(outData.getBytes());
                System.out.print(outData);
            }
            System.out.println();
            pipedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
