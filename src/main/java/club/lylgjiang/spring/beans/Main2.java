package club.lylgjiang.spring.beans;

import club.lylgjiang.spring.beans.pojo.Car;
import club.lylgjiang.spring.beans.util.Utils;
import org.springframework.context.ApplicationContext;

/**
 * @Classname Main2
 * @Description 程序测试入口类
 * @Date 2019/9/19 22:49
 * @Created by Jiavg
 */
public class Main2 {

    public static void main(String[] args) {
        
//        test01();
//        test02();
        test03();
        
    }
    
    public static void test01(){
        
        ApplicationContext context = Utils.getApplicationContext("Application-beans-factory.xml");

//        Car car = context.getBean("car", Car.class);
        Car car = context.getBean("car2", Car.class);

        System.out.println(car);

    }

    public static void test02(){

        ApplicationContext context = Utils.getApplicationContext("Application-beans-factory.xml");

//        Car car = context.getBean("car", Car.class);
        Car car = context.getBean("car2", Car.class);

        System.out.println(car);

    }
    
    public static void test03(){

        ApplicationContext context = Utils.getApplicationContext("Application-beans-factorybean.xml");

        Car car = context.getBean("car", Car.class);

        System.out.println(car);

    }
    
}
