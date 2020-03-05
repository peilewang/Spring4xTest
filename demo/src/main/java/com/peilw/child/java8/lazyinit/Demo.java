package com.peilw.child.java8.lazyinit;

public class Demo {
    public static void main(String[] args) {
        MyList<Integer> l = new MyLinkedList<>(5, new MyLinkedList<>(10, new Empty<>()));

    }
}
