package com.peilw.child.java8.design.observer;

public interface Subject {
    void registerObserver(Observer o);
    void notifyObservers(String tweet);
}
