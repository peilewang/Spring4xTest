package com.peilw.child.test;

public class Test {
    //static Person person=new Person("1");
    public static void main(String[] args ){
        //change(person);

       // System.out.println(person.name);
        String s1="abc1";//此处是数字1
        String s2="abc"+1;
        System.out.println(s1==s2);// 第一次比较
        String s3="ab";
        String s4="c";
        String s5="abc";
        String s6=s3+s4;
        String s7="ab"+"c";
        System.out.println(s5==s6);// 第二次比较
        System.out.println(s5==s7);// 第二次比较
    }

    public static void change(Person p) {
       // Person person = new Person("李四");
       // person = person;
      //  person.setName("2");
    }

}
