package club.lylgjiang.mybatis.selectparam;

import club.lylgjiang.mybatis.pojo.Department;
import club.lylgjiang.mybatis.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Classname SelectParamTest
 * @Description 测试类
 * @Date 2019/9/27 13:47
 * @Created by Jiavg
 */
public class SelectParamTest {
    
    @Test
    public void test01() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("selectparam/mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee emp = mapper.getEmpById(1);

        System.out.println(emp);

    }
    
    @Test
    public void test02() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("selectparam/mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee emp = mapper.getEmpByIdMap(1);

        System.out.println(emp);

    }
    
    @Test
    public void test03() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("selectparam/mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee emp = mapper.getEmpAndDeptById(1);

        System.out.println(emp);

    }
    
    @Test
    public void test04() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("selectparam/mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee emp = mapper.getEmpAndDeptByIdPlus(1);

        System.out.println(emp);

    }
    
    @Test
    public void test05() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("selectparam/mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee emp = mapper.getEmpAndDeptByIdPlusStep(1);
        emp.getDepartment();
        //System.out.println(emp);

    }
    
    @Test
    public void test06() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("selectparam/mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        Department department = mapper.getDeptByIdCol(1);
        System.out.println(department);

    }
    
    @Test
    public void test07() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("selectparam/mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        Department department = mapper.getDeptByIdColStep(1);
        System.out.println(department);

    }
    
    
}
