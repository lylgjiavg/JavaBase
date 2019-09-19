package club.lylgjiang.spring.beans.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Classname CarBeanPostProcessor
 * @Description Car类的后置处理器
 * @Date 2019/9/19 22:28
 * @Created by Jiavg
 */
public class CarBeanPostProcessor implements BeanPostProcessor {
    
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        
        if(beanName.equals("car")){
            System.out.println("Car's postProcessor of before. bean:" + bean);
        }
        
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        
        if(beanName.equals("car")){
            System.out.println("Car's postProcessor of after. bean:" + bean);
        }
        
        return bean;
    }
}
