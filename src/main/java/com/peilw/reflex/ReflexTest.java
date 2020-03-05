package com.peilw.reflex;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflexTest {
    public static void main(String[] args){
        Person person=new Person();
        Class person1=Person.class;
        Class c1=person.getClass();
        try {
            Class c3=Class.forName("com.peilw.reflex.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String className=c1.getName();
        System.out.println("className="+className);
        Field[] fields=c1.getFields();
        for (Field field:fields)
            System.out.println(field);

        Field[] field=c1.getDeclaredFields();
        for ( Field field1:field)
            System.out.println(field1);
        Method[] method=c1.getMethods();
        for(Method method1:method)
            System.out.println(method1);
        Method[] methods=c1.getDeclaredMethods();
        for(Method method1:methods)
            System.out.println(method1);
        try {
            Field f1=c1.getField("age");
            System.out.println(f1);
            Field f2=c1.getDeclaredField("name");
            f2.setAccessible(true);
            System.out.println(f2);
            try {
                Object p2=c1.newInstance();
                f2.set(p2,"peilw");
                System.out.println(f2.get(p2));
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        Constructor[] constructors=c1.getConstructors();
        for (Constructor constructor:constructors)
            System.out.println(constructor);
    }
}
