package club.lylgjiang.spring.tx.annotation;

/**
 * @Classname BookShopDao
 * @Description 
 * @Date 2019/9/21 15:40
 * @Created by Jiavg
 */
public interface BookShopDao {
    
    // 根据Isbn查找书的价格
    int findBookPriceByIsbn(String isbn);
    // 更新书的库存
    void updateBookStock(String isbn);
    // 更新账户余额
    void updateAccount(String username, int price);
    
}
