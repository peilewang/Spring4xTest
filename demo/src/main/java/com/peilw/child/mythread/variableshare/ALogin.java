package com.peilw.child.mythread.variableshare;

public class ALogin extends Thread{
    @Override
    public void run(){
        LoginServlet.doPost("a","aa");
    }
}
