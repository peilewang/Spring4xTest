package com.peilw.child.java8.design.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class Demo {
    final static Map<String, Supplier<Product>> map = new HashMap<>();

    static {
        map.put("loan", Loan::new);
        map.put("stock", Stock::new);
        map.put("bond", Bond::new);
    }

    public static Product createProduct(String name) {
        Supplier<Product> p = map.get(name);
        if (p != null) return p.get();
        throw new IllegalArgumentException("No such product " + name);
    }

    public static void main(String[] args) {
        BiFunction<String, String, String> biFunction = (a, b) -> a + b;
        TriFunction<Integer, Integer, String, Product> triFunction = (a,b,c) -> createProduct(c);
        System.out.println(biFunction.apply("Hello ", "Jack!")); // Hello Jack!
        Map<String, TriFunction<Integer, Integer, String, Product>> map = new HashMap<>();
        //map.put("aaa", TriFunction);
        Product p = ProductFactory.createProduct("loan");
        Supplier<Product> loanSupplier = Loan::new;
        Loan loan = (Loan) loanSupplier.get();
    }
}
