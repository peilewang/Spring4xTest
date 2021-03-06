package com.peilw.child.components;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
    @Pointcut("execution(* com.peilw.child.service.*.*(..))")
    public void pc1(){

    }
    @Before(value = "pc1()")
    public void before(JoinPoint joinPoint){
     String name=joinPoint.getSignature().getName();
     System.out.println(name+"方法开始执行");
    }
    @After(value = "pc1()")
    public void after(JoinPoint joinPoint){
        String name=joinPoint.getSignature().getName();
        System.out.println(name+"方法执行结束");
    }
    @AfterReturning(value = "pc1()",returning ="result")
    public void after(JoinPoint joinPoint,Object result){
        String name=joinPoint.getSignature().getName();
        System.out.println(name+"方法返回值为"+result);
    }
    @AfterThrowing(value = "pc1()",throwing = "e")
    public void after(JoinPoint joinPoint,Exception e){
        String name=joinPoint.getSignature().getName();
        System.out.println(name+"方法抛异常了，异常为"+e.getMessage());
    }
    @Around("pc1()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
         return  proceedingJoinPoint.proceed();
    }
}
