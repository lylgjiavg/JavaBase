package club.lylgjiang.spring.beans.annotation.service;

import club.lylgjiang.spring.beans.annotation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname UserService
 * @Description 服务层
 * @Date 2019/9/20 0:05
 * @Created by Jiavg
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public void saveService(){
        System.out.println("UserService save...");
        userRepository.save();
    }
    
}
