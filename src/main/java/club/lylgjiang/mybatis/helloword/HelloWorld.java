package club.lylgjiang.mybatis.helloword;

import club.lylgjiang.mybatis.mapper.EmployeeMapper;
import club.lylgjiang.mybatis.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * @Classname HelloWorld
 * @Description MyBatis尝鲜
 * @Date 2019/9/23 23:37
 * @Created by Jiavg
 */
public class HelloWorld {

    public static void main(String[] args) throws IOException {
        
//        test01();
        test02();
        
    }

    public static void test01() throws IOException {
        String path = "helloworld/mybatis-config.xml";

        InputStream inputStream = Resources.getResourceAsStream(path);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        Employee one = sqlSession.selectOne("club.lylgjiang.mybatis.pojo.Employee.selectById", 1);

        System.out.println(one);
    }

    public static void test02() throws IOException {
        String path = "helloworld/mybatis-config.xml";

        InputStream inputStream = Resources.getResourceAsStream(path);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        System.out.println(employeeMapper.selectById(2));
    }
    
    
}
