package com.peilw.child.java8.Lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        /*布尔表达式 (List<String> list) -> list.isEmpty()
        创建对象 () -> new Apple(10)
        消费一个对象 (Apple a) -> {
            System.out.println(a.getWeight());
        }
        从一个对象中选择/抽取 (String s) -> s.length()
        组合两个值 (int a, int b) -> a * b
        比较两个对象 (Apple a1, Apple a2) ->
        a1.getWeight().compareTo(a2.getWeight())*/
        List listOfStrings = new ArrayList();
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> nonEmpty = filter(listOfStrings, nonEmptyStringPredicate);

    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T s : list) {
            if (p.test(s)) {
                results.add(s);
            }
        }
        return results;
    }
}
