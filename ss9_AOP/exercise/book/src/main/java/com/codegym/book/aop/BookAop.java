package com.codegym.book.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookAop {
    private int requestToServer = 0;
    @Pointcut("within(com.codegym.book.*)")
    public void countRequestToServer(){}
    @Before("countRequestToServer()")
    public void beforeCallMethod(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature());
        this.requestToServer++;
        System.out.println("Request to server:" + this.requestToServer +" time");
    }
}
