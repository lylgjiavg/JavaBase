package club.lylgjiang.spring.tx.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Classname CashierImpl
 * @Description 
 * @Date 2019/9/21 16:54
 * @Created by Jiavg
 */
@Component("cashierImpl")
public class CashierImpl implements Cashier {
    
    @Autowired
    private BookShopService bookShopService;
    
    @Transactional(timeout = 2)
    @Override
    public void checkout(String username, List<String> books) {
        
        for (String book : books) {
            bookShopService.purchase(username, book);
        }

    }
    
}
