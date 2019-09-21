package club.lylgjiang.spring.tx;

import club.lylgjiang.spring.beans.util.Utils;
import club.lylgjiang.spring.tx.annotation.BookShopService;
import club.lylgjiang.spring.tx.annotation.BookShopServiceImpl;
import club.lylgjiang.spring.tx.annotation.Cashier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Test
 * @Description 测试类
 * @Date 2019/9/21 16:20
 * @Created by Jiavg
 */
public class Test {
    
    
    private BookShopService bookShopService;
    private Cashier cashier;
    

    {
        ApplicationContext context = Utils.getApplicationContext("Application-tx-annotation.xml");
        bookShopService = context.getBean("bookShopServiceImpl", BookShopService.class);
        cashier = context.getBean("cashierImpl", Cashier.class);
    }
    
    @org.junit.Test
    public void test01(){
        
        bookShopService.purchase("jlc", "1001");
        
    }
    
    @org.junit.Test
    public void test02(){
        
        List<String> books = new ArrayList<>();
        books.add("1001");
        books.add("1002");
        
        cashier.checkout("jlc", books);
        
    }
    
}
