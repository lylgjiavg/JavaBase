package club.lylgjiang.spring.beans;

import club.lylgjiang.spring.beans.annotation.controller.UserController;
import club.lylgjiang.spring.beans.annotation.pojo.User;
import club.lylgjiang.spring.beans.annotation.service.CartService;
import club.lylgjiang.spring.beans.util.Utils;
import org.springframework.context.ApplicationContext;

/**
 * @Classname Main3
 * @Description 程序入口类:测试注解
 * @Date 2019/9/20 0:09
 * @Created by Jiavg
 */
public class Main3 {

    public static void main(String[] args) {
        
//        test01();
        test02();
        
    }
    
    public static void test01(){

        ApplicationContext applicationContext = Utils.getApplicationContext("Application-beans-annotation.xml");

        UserController userController = applicationContext.getBean("userController", UserController.class);
        userController.execute();

        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);

    }
    
    public static void test02(){

        ApplicationContext applicationContext = Utils.getApplicationContext("Application-beans-annotation.xml");

        CartService cartService = applicationContext.getBean("cartService", CartService.class);
        cartService.save();

    }
    
    
}
