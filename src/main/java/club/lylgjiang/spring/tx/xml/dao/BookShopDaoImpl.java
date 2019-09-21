package club.lylgjiang.spring.tx.xml.dao;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Classname BookShopDaoImpl
 * @Description 
 * @Date 2019/9/21 15:48
 * @Created by Jiavg
 */
public class BookShopDaoImpl implements BookShopDao {
    
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int findBookPriceByIsbn(String isbn) {
        
        String sql = "SELECT price FROM book where isbn=?";

        Integer price = jdbcTemplate.queryForObject(sql, Integer.class, isbn);

        return price;
    }

    @Override
    public void updateBookStock(String isbn) {
        
        String selectStockSql = "SELECT stock FROM book_stock WHERE isbn=?";

        Integer stock = jdbcTemplate.queryForObject(selectStockSql, Integer.class, isbn);
        if (stock == 0) {
            throw new RuntimeException("库存不足!");
        }

        String sql = "UPDATE book_stock SET stock=stock-1 WHERE isbn=?";
        jdbcTemplate.update(sql, isbn);
    }

    @Override
    public void updateAccount(String username, int price) {
        String selectStockSql = "SELECT balance FROM account WHERE username=?";

        Integer balance = jdbcTemplate.queryForObject(selectStockSql, Integer.class, username);
        if (balance < price) {
            throw new RuntimeException("余额不足!");
        }

        String sql = "UPDATE account SET balance=balance-? WHERE username=?";
        jdbcTemplate.update(sql, price, username);
    }
}
