package club.lylgjiang.spring.aop.xml;

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
public class ValidationAspect {
    
    public void before(){
        System.out.println("---> ValidationAspect-before");
    }
    
}
