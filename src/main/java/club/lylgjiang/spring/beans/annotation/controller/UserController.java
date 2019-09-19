package club.lylgjiang.spring.beans.annotation.controller;

import club.lylgjiang.spring.beans.annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Classname UserController
 * @Description 表现层
 * @Date 2019/9/20 0:05
 * @Created by Jiavg
 */
@Controller
public class UserController {
    
    @Autowired
    private UserService userService;
    
    public void execute(){
        System.out.println("UserController execute...");
        userService.saveService();
    }
    
}
