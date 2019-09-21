package club.lylgjiang.spring.tx.xml.service.impl;

import club.lylgjiang.spring.tx.xml.service.BookShopService;
import club.lylgjiang.spring.tx.xml.service.Cashier;

import java.util.List;

/**
 * @Classname CashierImpl
 * @Description 
 * @Date 2019/9/21 16:54
 * @Created by Jiavg
 */
public class CashierImpl implements Cashier {
    
    private BookShopService bookShopService;

    public void setBookShopService(BookShopService bookShopService) {
        this.bookShopService = bookShopService;
    }

    @Override
    public void checkout(String username, List<String> books) {
        
        for (String book : books) {
            bookShopService.purchase(username, book);
        }

    }
    
}
