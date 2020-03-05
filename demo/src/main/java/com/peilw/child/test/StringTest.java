package com.peilw.child.test;

public class StringTest {
        public static final String s11="abc";
        public static final String s22="def";
        public static void main(String[] args) {
            String s1="abc";
            String s2="def";
            String s3=s1+s2;
            String s4="abcdef";
            System.out.println(s3==s4);
            //解释：因为s1和s2都是final类型的且在编译阶段都是已经复制了，所以相当于一个常量，当执行Strings3=s1+s2;的时候，s3已经是字符串abcdef了，所以相等。
        }
}
