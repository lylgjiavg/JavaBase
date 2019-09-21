package club.lylgjiang.spring.aop;

import club.lylgjiang.spring.aop.dynamicproxy.Calculate;
import club.lylgjiang.spring.aop.dynamicproxy.CalculateProxy;
import club.lylgjiang.spring.aop.dynamicproxy.ICalculate;
import club.lylgjiang.spring.beans.util.Utils;
import org.springframework.context.ApplicationContext;

/**
 * @Classname Main
 * @Description 程序入口类
 * @Date 2019/9/20 14:14
 * @Created by Jiavg
 */
public class Main {

    public static void main(String[] args) {
        
//        test01();
        test02();
        
    }
    
    public static void test01(){

        Calculate calculate = new Calculate();

        CalculateProxy calculateProxy = new CalculateProxy(calculate);
        ICalculate loggerProxy = calculateProxy.getLoggerProxy();

        int resultAdd = loggerProxy.add(1, 2);

        System.out.println(resultAdd);

    }
    
    public static void test02(){

        ApplicationContext context = Utils.getApplicationContext("Application-aop-annotation.xml");

        club.lylgjiang.spring.aop.aspectj.ICalculate calculate = context.getBean("calculate", club.lylgjiang.spring.aop.aspectj.ICalculate.class);
        
        calculate.div(6, 2);

        System.out.println("=======================");
        
        calculate.div(1, 0);

    }
    
    
}
