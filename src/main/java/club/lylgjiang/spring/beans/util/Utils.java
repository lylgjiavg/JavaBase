package club.lylgjiang.spring.beans.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Classname Utils
 * @Description 工具类
 * @Date 2019/9/18 21:27
 * @Created by Jiavg
 */
public class Utils {

    private Utils() {
    }

    public static ApplicationContext getApplicationContext(){
        ApplicationContext context = 
                new ClassPathXmlApplicationContext("Application-beans.xml");
        
        return context;
    }
    
}
