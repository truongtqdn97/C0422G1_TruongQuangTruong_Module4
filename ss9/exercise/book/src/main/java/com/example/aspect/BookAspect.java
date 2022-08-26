package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class BookAspect {
    private static int count = 0;

    @AfterReturning(pointcut = "execution(* com.example.controller.BookController.*(..))")
    public void countProceeding(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.err.println("method " + methodName + " đã chạy xong!");
        System.err.println(args);
        count++;
        System.err.println("thống kê tương tác: " + count);
    }
}
