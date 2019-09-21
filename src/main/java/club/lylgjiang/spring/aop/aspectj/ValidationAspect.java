package club.lylgjiang.spring.aop.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Classname ValidationAspect
 * @Description 校验通知
 * @Date 2019/9/20 16:09
 * @Created by Jiavg
 */
@Order(1)
@Aspect
@Component
public class ValidationAspect {
    
    @Before("club.lylgjiang.spring.aop.aspectj.LoggerAspect.declarePointcut()")
    public void before(){
        System.out.println("---> ValidationAspect-before");
    }
    
    
}
