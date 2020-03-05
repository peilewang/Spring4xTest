package com.peilw.child.mythread.variableshare;

public class BLogin extends Thread{
    @Override
    public void run(){
         LoginServlet.doPost("b","bb");
    }
}
