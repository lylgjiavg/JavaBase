package club.lylgjiang.spring.tx.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Classname BookShopServiceImpl
 * @Description 
 * @Date 2019/9/21 16:22
 * @Created by Jiavg
 */
@Service("bookShopServiceImpl")
public class BookShopServiceImpl implements BookShopService{

    @Autowired
    private BookShopDao bookShopDao;
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void purchase(String username, String isbn) {
        
        // 查找书籍价格
        int bookPrice = bookShopDao.findBookPriceByIsbn(isbn);
        // 更新库存
        bookShopDao.updateBookStock(isbn);
        // 更新账户余额
        bookShopDao.updateAccount(username, bookPrice);

    }
    
}
