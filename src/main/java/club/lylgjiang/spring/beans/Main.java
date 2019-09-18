package club.lylgjiang.spring.beans;

import club.lylgjiang.spring.beans.pojo.Collections;
import club.lylgjiang.spring.beans.util.Utils;
import org.springframework.context.ApplicationContext;

/**
 * @Classname Main
 * @Description 程序入口类
 * @Date 2019/9/18 21:24
 * @Created by Jiavg
 */
public class Main {

    public static void main(String[] args) {
        test01();
    }
    
    public  static void test01(){

        ApplicationContext context = Utils.getApplicationContext();

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
    
    
}
