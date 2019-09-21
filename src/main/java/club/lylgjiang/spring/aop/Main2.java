package club.lylgjiang.spring.aop;

import club.lylgjiang.spring.aop.xml.ICalculate;
import club.lylgjiang.spring.beans.util.Utils;
import org.springframework.context.ApplicationContext;

/**
 * @Classname Main2
 * @Description 程序入口类
 * @Date 2019/9/20 18:59
 * @Created by Jiavg
 */
public class Main2 {

    public static void main(String[] args) {
        test01();
    }
    
    public static void test01(){

        ApplicationContext context = Utils.getApplicationContext("Application-aop-xml.xml");

        ICalculate calculate = context.getBean("calculate", ICalculate.class);
        calculate.div(6, 3);
        calculate.div(6, 0);

    }
    
}
