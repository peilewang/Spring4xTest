package com.peilw.child.config;

import org.springframework.boot.CommandLineRunner;

public class MyCommandLineRunner2 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("MyCommandLineRunner2--->"+ java.util.Arrays.toString(args));
    }
}
