package club.lylgjiang.spring.jdbc.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

/**
 * @Classname DepartmentRepository
 * @Description 部门持久类
 * @Date 2019/9/21 8:51
 * @Created by Jiavg
 */
@Component
public class DepartmentRepository extends JdbcDaoSupport {
    
    @Autowired
    public void setJdbcTemp(JdbcTemplate jdbcTemp){
        setJdbcTemplate(jdbcTemp);
    }

    public long selectRows(){

        String sql = "SELECT count(*) FROM department";

        Long rows = getJdbcTemplate().queryForObject(sql, Long.class);

        return rows;
    }
    
}
