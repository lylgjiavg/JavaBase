package club.lylgjiang.spring.jdbc.template;

import club.lylgjiang.spring.jdbc.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

/**
 * @Classname EmployeeRepository
 * @Description 雇员持久层
 * @Date 2019/9/21 7:21
 * @Created by Jiavg
 */
@Repository
public class EmployeeRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 从数据库中获取一条记录, 实际得到对应的一个对象
     * 注意不是调用 queryForObject(String sql, Class<Employee> requiredType, Object... args) 方法!
     * 而需要调用 queryForObject(String sql, RowMapper<Employee> rowMapper, Object... args)
     * 1. 其中的 RowMapper 指定如何去映射结果集的行, 常用的实现类为 BeanPropertyRowMapper
     * 2. 使用 SQL 中列的别名完成列名和类的属性名的映射. 例如 last_name lastName
     * 3. 不支持级联属性. JdbcTemplate 到底是一个 JDBC 的小工具, 而不是 ORM 框架
     */
    public Employee getById(Integer id){
        
        String sql = "SELECT id, name, age, sax FROM employee where id = ?";

        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, 1);

        return employee;
    }

    /**
     * 查到实体类的集合
     * 注意调用的不是 queryForList 方法
     */
    public List getList(){
        
        String sql = "SELECT id, name, age, sax FROM employee";

        RowMapper<Employee> tRowMapper = new BeanPropertyRowMapper<>(Employee.class);
        List<Employee> employees = jdbcTemplate.query(sql, tRowMapper);

        return employees;
    }

    /**
     * 执行批量更新: 批量的 INSERT, UPDATE, DELETE
     * 最后一个参数是 Object[] 的 List 类型: 因为修改一条记录需要一个 Object 的数组, 那么多条不就需要多个 Object 的数组吗
     */
    public int[] insertEmployee(List<Employee> employees){
        
        String sql = "INSERT INTO employee(id, name, age, sax) VALUES(?,?,?,?)";
        List<Object[]> list = new LinkedList<>();
        for (Employee employee : employees) {
            Integer id = employee.getId();
            String name = employee.getName();
            Integer age = employee.getAge();
            String sax = employee.getSax();
            Object[] object = new Object[]{id, name, age, sax};
            list.add(object);
        }


        int[] ints = jdbcTemplate.batchUpdate(sql, list);

        return ints;
    }
    
    public int updateById(Employee employee){
        
        String sql = "UPDATE employee SET name=?,age=?,sax=? WHERE id=?";

        int i = jdbcTemplate.update(sql, employee.getName(), employee.getAge(),
                employee.getSax(), employee.getId());

        return i;
    }
    
    public int deleteById(Integer id){
        
        String sql = "DELETE FROM employee WHERE id=?";

        int update = jdbcTemplate.update(sql, id);

        return update;
    }

    /**
     * 获取单个列的值, 或做统计查询
     * 使用 queryForObject(String sql, Class<Long> requiredType) 
     */
    public long selectRows(){
        
        String sql = "SELECT count(*) FROM employee";

        Long rows = jdbcTemplate.queryForObject(sql, Long.class);
        
        return rows;
    }
    
}
