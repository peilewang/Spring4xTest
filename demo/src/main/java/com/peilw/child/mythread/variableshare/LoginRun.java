package com.peilw.child.mythread.variableshare;

public class LoginRun {
    public static void main(String[] args){
      ALogin aLogin=new ALogin();
      aLogin.start();
      BLogin bLogin=new BLogin();
      bLogin.start();
    }
}
