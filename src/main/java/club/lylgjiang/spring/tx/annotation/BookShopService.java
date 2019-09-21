package club.lylgjiang.spring.tx.annotation;

/**
 * @Classname BookShopService
 * @Description 
 * @Date 2019/9/21 16:21
 * @Created by Jiavg
 */
public interface BookShopService {
    
    // 购买书籍
    void purchase(String username, String isbn);
    
}
