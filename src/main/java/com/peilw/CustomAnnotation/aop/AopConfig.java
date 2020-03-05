package com.peilw.CustomAnnotation.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("com.peilw.CustomAnnotation.aop")
@EnableAspectJAutoProxy
public class AopConfig {

}

