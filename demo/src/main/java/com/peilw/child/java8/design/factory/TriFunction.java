package com.peilw.child.java8.design.factory;

public interface TriFunction<T, U, V, R>{
    R apply(T t, U u, V v);
}
