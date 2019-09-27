package club.lylgjiang.mybatis.mapperconfig;

import club.lylgjiang.mybatis.pojo.Employee;

/**
 * @Classname EmployeeMapper
 * @Description 雇员持久化接口开发类
 * @Date 2019/9/25 14:35
 * @Created by Jiavg
 */
public interface EmployeeMapper {
    
    // 增
    public void addEmp(Employee employee);
    // 删
    public void delEmpById(Integer id);
    // 改
    public void updateEmp(Employee employee);
    // 查
    public Employee selectEmpById(Integer id);
    
}
