package club.lylgjiang.mybatis.globalconfig;

import club.lylgjiang.mybatis.mapper.EmployeeMapper;
import club.lylgjiang.mybatis.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.type.TypeHandler;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Classname HelloWorld
 * @Description MyBatis:验证全局配置文件
 * @Date 2019/9/23 23:37
 * @Created by Jiavg
 */
public class GlobalConfig {

    public static void main(String[] args) throws IOException {
        
        test01();
        
    }

    public static void test01() throws IOException {
        String path = "globalconfig/mybatis-config.xml";

        InputStream inputStream = Resources.getResourceAsStream(path);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        System.out.println(employeeMapper.selectById(2));
    }
    
    
}
