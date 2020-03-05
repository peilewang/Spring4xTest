package com.peilw.child.java8.design.templateMethod;

public class Demo {
    public static void main(String[] args) {
        new OnlineBankingLambda().processCustomer(1337, (Customer c) -> System.out.println("Hello " + c.getName()));
    }
}
