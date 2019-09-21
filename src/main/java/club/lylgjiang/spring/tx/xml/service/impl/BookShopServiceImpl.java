package club.lylgjiang.spring.tx.xml.service.impl;

import club.lylgjiang.spring.tx.xml.dao.BookShopDao;
import club.lylgjiang.spring.tx.xml.service.BookShopService;

/**
 * @Classname BookShopServiceImpl
 * @Description 
 * @Date 2019/9/21 16:22
 * @Created by Jiavg
 */
public class BookShopServiceImpl implements BookShopService {

    private BookShopDao bookShopDao;

    public void setBookShopDao(BookShopDao bookShopDao) {
        this.bookShopDao = bookShopDao;
    }

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
