package club.lylgjiang.spring.jdbc;

import club.lylgjiang.spring.beans.util.Utils;
import club.lylgjiang.spring.jdbc.pojo.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname Test2
 * @Description 测试类
 * @Date 2019/9/21 15:00
 * @Created by Jiavg
 */
public class Test2 {

    private NamedParameterJdbcTemplate jdbcTemplate;
    
    {
        ApplicationContext context = Utils.getApplicationContext("Application-jdbc-template.xml");
        jdbcTemplate = context.getBean("namedParameterJdbcTemplate", NamedParameterJdbcTemplate.class);
    }
    
    @Test
    public void test01(){
        
        /*
         * 具名参数: SQL 按名称(以冒号开头)而不是按位置进行指定. 具名参数更易于维护, 也提升了可读性.
         * 具名参数由框架类在运行时用占位符取代
         * */
        String sql = "INSERT INTO employee(id, name, age, sax) VALUES(:id,:name,:age,:sax)";

        /**
         * 可以为参数起名字. 
         * 1. 好处: 若有多个参数, 则不用再去对应位置, 直接对应参数名, 便于维护
         * 2. 缺点: 较为麻烦. 
         */
        Map<String, Object> map = new HashMap<>();
        map.put("id", 6);
        map.put("name", "AA");
        map.put("age", 23);
        map.put("sax", "woman");
        
        int update = jdbcTemplate.update(sql, map);
        System.out.println(update);

    }
    
    @Test
    public void test02(){
        
        String sql = "INSERT INTO employee(id, name, age, sax) VALUES(:id,:name,:age,:sax)";

        Employee employee = new Employee(7, "BB", 32, "woman");

        /**
         * 使用具名参数时, 可以使用 update(String sql, SqlParameterSource paramSource) 方法进行更新操作
         * 1. SQL 语句中的参数名和类的属性一致!
         * 2. 使用 SqlParameterSource 的 BeanPropertySqlParameterSource 实现类作为参数. 
         */
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(employee);
        
        int update = jdbcTemplate.update(sql, sqlParameterSource);
        System.out.println(update);

    }
    
    
}
