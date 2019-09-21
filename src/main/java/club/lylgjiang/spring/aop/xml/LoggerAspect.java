package club.lylgjiang.spring.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Classname LoggerAspect
 * @Description 切面
 * @Date 2019/9/20 14:31
 * @Created by Jiavg
 */
public class LoggerAspect {
 
    public void before(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        System.out.println("method " + methodName + " begin with arg" + Arrays.asList(args));
    }

    public void after(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();

        System.out.println("method " + methodName + " end");
    }

    public void afterReturning(JoinPoint joinPoint, int result){
        String methodName = joinPoint.getSignature().getName();

        System.out.println("method " + methodName + " end with result = " + result);
    }

    public void afterThrowing(JoinPoint joinPoint, Exception exception){
        String name = joinPoint.getSignature().getDeclaringType().getName();

        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        System.out.println(name + "." + methodName + "(" + Arrays.asList(args) + ")" + "产生异常: " + exception);
    }

    public Object around(ProceedingJoinPoint proceedingJoinPoint){
        Object proceed = null;
        try {
            System.out.println("前置通知");
            proceed = proceedingJoinPoint.proceed();
            System.out.println("后置返回通知");
        } catch (Throwable throwable) {
            System.out.println("异常通知");
        }finally {
            System.out.println("后置通知");
        }

        return proceed;
    } 
    
}
