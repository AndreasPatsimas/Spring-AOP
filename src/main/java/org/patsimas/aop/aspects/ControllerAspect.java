package org.patsimas.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.patsimas.aop.utils.AuthorizeUtils;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ControllerAspect {

    @Before(value = "execution(* org.patsimas.aop.controllers..*.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {

        System.out.println("Before method:" + joinPoint.getSignature());

        String username = (String) getParameterByName((ProceedingJoinPoint) joinPoint, "username");
        String principal = (String) getParameterByName((ProceedingJoinPoint) joinPoint, "principal");
        AuthorizeUtils.authorizeRequest(username, principal);
    }

    public Object getParameterByName(ProceedingJoinPoint proceedingJoinPoint, String parameterName) {
        MethodSignature methodSig = (MethodSignature) proceedingJoinPoint.getSignature();
        Object[] args = proceedingJoinPoint.getArgs();
        String[] parametersName = methodSig.getParameterNames();

        int idx = Arrays.asList(parametersName).indexOf(parameterName);

        if(args.length > idx) { // parameter exist
            return args[idx];
        } // otherwise your parameter does not exist by given name
        return null;

    }
}
