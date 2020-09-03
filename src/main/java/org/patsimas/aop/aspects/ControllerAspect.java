package org.patsimas.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class ControllerAspect {

    @Before(value = "execution(* org.patsimas.aop.controllers..*.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("Before method:" + joinPoint.getSignature());

        List args = Arrays.asList(joinPoint.getArgs());
        args.forEach(arg -> System.out.println((String) arg));
        //System.out.println("Creating Employee with first name - " + fname + ", second name - " + sname + " and id - " + empId);
    }
}
