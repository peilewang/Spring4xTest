package com.peilw.child.java8.lazyinit.Lazy;

public class Demo {
    public static void main(String[] args){

    }
    public static LazyList<Integer> from(int n) {
        return new LazyList<Integer>(n, () -> from(n+1));
    }
}
