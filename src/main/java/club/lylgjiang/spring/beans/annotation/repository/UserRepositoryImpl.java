package club.lylgjiang.spring.beans.annotation.repository;

import org.springframework.stereotype.Repository;

/**
 * @Classname UserRepositoryImpl
 * @Description 持久层
 * @Date 2019/9/20 0:05
 * @Created by Jiavg
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
    
    @Override
    public void save() {
        System.out.println("UserRepositoryImpl save...");
    }
    
}
