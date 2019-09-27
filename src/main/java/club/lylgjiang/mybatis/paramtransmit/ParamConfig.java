package club.lylgjiang.mybatis.paramtransmit;

import club.lylgjiang.mybatis.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname ParamConfig
 * @Description 参数注入测试类
 * @Date 2019/9/25 21:11
 * @Created by Jiavg
 */
public class ParamConfig {
    
    @Test
    public void test01() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("paramtransmit/mybatis-config.xml");

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

//        Employee employee = mapper.selectById(2);

//        Employee employee = mapper.selectByIdAndName(2, "lx");
        
//        Map<String, Object> params = new HashMap<>();
//        params.put("id", 2);
//        params.put("lastName", "lx");
//        Employee employee = mapper.selectByIdAndNameMap(params);

        
        Employee employee = mapper.selectByIdAndNameSetTB(2, "lx", "tb1_employee");
        

        System.out.println(employee);

    }
    
}
