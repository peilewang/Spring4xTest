package com.peilw.child.controller;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("init");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("destory");
    }
}
