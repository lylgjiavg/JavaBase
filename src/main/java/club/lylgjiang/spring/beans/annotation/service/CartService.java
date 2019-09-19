package club.lylgjiang.spring.beans.annotation.service;

import org.springframework.stereotype.Service;

/**
 * @Classname CartService
 * @Description 泛型依赖注入
 * @Date 2019/9/20 0:36
 * @Created by Jiavg
 */
@Service
public class CartService extends BaseService{
    
    public void save(){
        System.out.println(this.baseRepository);
    }
    
}
