package club.lylgjiang.spring.jdbc;

import club.lylgjiang.spring.beans.util.Utils;
import club.lylgjiang.spring.jdbc.pojo.Employee;
import club.lylgjiang.spring.jdbc.template.DepartmentRepository;
import club.lylgjiang.spring.jdbc.template.EmployeeRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Test
 * @Description 测试类
 * @Date 2019/9/21 7:39
 * @Created by Jiavg
 */
public class Test {
    
    private JdbcTemplate jdbcTemplate;
    private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;
    
    {
        ApplicationContext context = Utils.getApplicationContext("Application-jdbc-template.xml");
        jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        employeeRepository = context.getBean("employeeRepository", EmployeeRepository.class);
        departmentRepository = context.getBean("departmentRepository", DepartmentRepository.class);
    }
    
    @org.junit.Test
    public void test01(){

        Employee employee = employeeRepository.getById(1);

        System.out.println(employee);
    }
    
    @org.junit.Test
    public void test02(){

        List list = employeeRepository.getList();

        System.out.println(list);
    }
    
    @org.junit.Test
    public void test03(){

        List list = new ArrayList();
        list.add(new Employee(4, "jlc", 20, "max"));
        list.add(new Employee(5, "lx", 21, "max"));
        list.add(new Employee(6, "znc", 22, "max"));

        int[] ints = employeeRepository.insertEmployee(list);

        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }
    
    @org.junit.Test
    public void test04(){

        Employee employee = new Employee(4, "jiavg", 19, "max");
        
        int i = employeeRepository.updateById(employee);
        
        System.out.println(i);

    }
    
    @org.junit.Test
    public void test05(){
        
        int i = employeeRepository.deleteById(6);
        
        System.out.println(i);

    }
    
    @org.junit.Test
    public void test06(){
        
        long i = employeeRepository.selectRows();
        
        System.out.println(i);
    }
    
    @org.junit.Test
    public void test07(){
        
        long i = departmentRepository.selectRows();
        
        System.out.println(i);
    }
    
}
