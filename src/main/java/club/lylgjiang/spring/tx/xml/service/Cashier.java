package club.lylgjiang.spring.tx.xml.service;

import java.util.List;

/**
 * @Classname Cashier
 * @Description 
 * @Date 2019/9/21 16:53
 * @Created by Jiavg
 */
public interface Cashier {
    
    // 结账操作
    void checkout(String username, List<String> books);
    
}
