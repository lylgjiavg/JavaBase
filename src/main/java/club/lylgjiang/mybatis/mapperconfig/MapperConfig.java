package club.lylgjiang.mybatis.mapperconfig;

import club.lylgjiang.mybatis.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

/**
 * @Classname MapperConfig
 * @Description Mapper文件测试类
 * @Date 2019/9/25 14:29
 * @Created by Jiavg
 */
public class MapperConfig {
    
    @Test
    public void test01() throws Exception {

        InputStream inputStream = Resources.getResourceAsStream("mapperconfig/mybatis-config.xml");

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获得一个Session对象
        // openSession():获得的对象必须手动提交
        // openSession(true):获得的对象自动提交
        SqlSession sqlSession = sessionFactory.openSession();

        try {

            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            /*增*/
//            Employee employee = new Employee(null, "xxx", "1", "xxx@github.com");
//            mapper.addEmp(employee);
            
            /*删*/
//            mapper.delEmpById(5);
            
            /*改*/
//            Employee employee = new Employee(4, "qqq", "1", "qqq@github.com");
//            mapper.updateEmp(employee);
            
            /*查*/
            Employee employee = mapper.selectEmpById(2);
            System.out.println(employee);

            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
        
    }
    
}
