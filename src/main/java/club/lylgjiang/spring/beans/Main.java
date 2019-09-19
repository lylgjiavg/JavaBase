package club.lylgjiang.spring.beans;

import club.lylgjiang.spring.beans.pojo.Car;
import club.lylgjiang.spring.beans.pojo.Collections;
import club.lylgjiang.spring.beans.pojo.Company;
import club.lylgjiang.spring.beans.pojo.Person;
import club.lylgjiang.spring.beans.util.Utils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Classname Main
 * @Description 程序入口类
 * @Date 2019/9/18 21:24
 * @Created by Jiavg
 */
public class Main {

    public static void main(String[] args) {
        
//        test01();
//        test02();
//        test03();
//        test04();
//        test05();
//        test06();
        test07();
        
    }
    
    public  static void test01(){

        ApplicationContext context = Utils.getApplicationContext("Application-beans.xml");

//        Person person = context.getBean("person01", Person.class);
//        Person person = context.getBean("person02", Person.class);
//        Person person = context.getBean("person03", Person.class);
//        Person person = context.getBean("person04", Person.class);
//        Person person = context.getBean("person05", Person.class);
//        Person person = context.getBean("person06", Person.class);
//        Person person = context.getBean("person07", Person.class);
//        Person person = context.getBean("person08", Person.class);
        Collections collections = context.getBean("collections01", Collections.class);
        
//        System.out.println(person);
        System.out.println(collections);
    }
    
    public static void test02(){
        
        ApplicationContext context = Utils.getApplicationContext("Application-beans-autowire.xml");

//        Person person = context.getBean("person", Person.class);
        Company company = context.getBean("company", Company.class);
        
//        System.out.println(person);
        System.out.println(company);

    }
    
    public static void test03(){
        
        ApplicationContext context = Utils.getApplicationContext("Application-beans-release.xml");

        Company taobao = context.getBean("taobao", Company.class);
        Company zhifubao = context.getBean("zhifubao", Company.class);
        Company hellobike = context.getBean("hellobike", Company.class);
        
        System.out.println(taobao);
        System.out.println(zhifubao);
        System.out.println(hellobike);

    }
    
    public static void test04(){

        ApplicationContext context = Utils.getApplicationContext("Application-beans-scope.xml");

        Person person1 = context.getBean("person", Person.class);
        Person person2 = context.getBean("person", Person.class);
        Person person3 = context.getBean("person-prototype", Person.class);
        Person person4 = context.getBean("person-prototype", Person.class);

        System.out.println(person1);
        System.out.println(person1 == person2);
        System.out.println(person3 == person4);

    }

    public static void test05(){

        ApplicationContext context = Utils.getApplicationContext("Application-beans-property.xml");

        DataSource dataSource = context.getBean("dataSource", DataSource.class);
        try {
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void test06(){

        ApplicationContext context = Utils.getApplicationContext("Application-beans-spel.xml");

        Person person = context.getBean("person", Person.class);
        System.out.println(person);

    }

    public static void test07(){
        // 调用 Bean 的初始化方法
        ClassPathXmlApplicationContext context = (ClassPathXmlApplicationContext) Utils.getApplicationContext("Application-beans-cycle.xml");

        Car car = context.getBean("car", Car.class);
        System.out.println(car);
        
        // 当容器关闭时, 调用 Bean 的销毁方法
        context.close();
        
    }


}
