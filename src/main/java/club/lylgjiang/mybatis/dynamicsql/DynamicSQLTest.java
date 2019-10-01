package club.lylgjiang.mybatis.dynamicsql;

import club.lylgjiang.mybatis.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname DynamicSQLTest
 * @Description 动态SQL测试类
 * @Date 2019/9/28 16:40
 * @Created by Jiavg
 */
public class DynamicSQLTest {
    
    @Test
    public void test_If() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("dynamicsql/mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> emps = mapper.getEmpByConductIf(new Employee(null, "%l%", null, null));

        for (Employee emp : emps) {
            System.out.println(emp);
        }
    }
    
    @Test
    public void test_Where() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("dynamicsql/mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> emps = mapper.getEmpByConductWhere(new Employee(1, "%l%", null, null));

        for (Employee emp : emps) {
            System.out.println(emp);
        }
    }
    
    @Test
    public void test_Choose() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("dynamicsql/mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> emps = mapper.getEmpByConductChoose(new Employee(null, null, null, null));

        for (Employee emp : emps) {
            System.out.println(emp);
        }
    }
    
    @Test
    public void test_Trim() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("dynamicsql/mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> emps = mapper.getEmpByConductTrim(new Employee(1, null, null, null));

        for (Employee emp : emps) {
            System.out.println(emp);
        }
    }
    
    @Test
    public void test_Foreach() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("dynamicsql/mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();

        Employee employee = new Employee(null, "ycg", "1", "ycg@git.com");
        LinkedList<Employee> list = new LinkedList<>();
        list.add(employee);

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        long count = mapper.insertEmpConductForeach(list);

        System.out.println(count);
        System.out.println(employee);
        sqlSession.commit();
    }

    @Test
    public void test_Set() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("dynamicsql/mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        long count = mapper.updateEmpConductSet(new Employee(4, "ycg", "0", "ycg@git.com"));

        System.out.println(count);
        sqlSession.commit();
    }

    @Test
    public void test_Bind() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("dynamicsql/mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employees = mapper.getEmpByLikeNameConductBind("l");

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void test_InnerParam() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("dynamicsql/mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.getEmpByConductInnerParam(1);
        
        System.out.println(employee);
    }

}
